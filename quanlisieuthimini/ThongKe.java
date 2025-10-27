import java.util.*;
import java.util.regex.*;

public class ThongKe {
	public static void thongKe(QuanLyCuaHang ql) {
		Map<String, Integer> imported = new HashMap<>();
		Map<String, Integer> sold = new HashMap<>();

		double totalImportCost = 0.0;
		double costOfGoodsSold = 0.0;

		// Parse imports
		for (NhapHang pn : ql.getDsPhieuNhap()) {
			String ct = pn.getChiTiet();
			parseChiTietAndAdd(ct, imported);
		}

		// Parse sales
		double totalRevenue = 0;
		for (HoaDon hd : ql.getDsHoaDon()) {
			String ct = hd.getChiTiet();
			parseChiTietAndAdd(ct, sold);
			totalRevenue += hd.getTongTien();
		}

		// compute costs based on catalog prices
		for (Map.Entry<String,Integer> e : imported.entrySet()) {
			String name = e.getKey();
			int qty = e.getValue();
			double cost = findGiaNhap(ql, name);
			totalImportCost += cost * qty;
		}
		for (Map.Entry<String,Integer> e : sold.entrySet()) {
			String name = e.getKey();
			int qty = e.getValue();
			double cost = findGiaNhap(ql, name);
			costOfGoodsSold += cost * qty;
		}

		int totalImported = imported.values().stream().mapToInt(Integer::intValue).sum();
		int totalSold = sold.values().stream().mapToInt(Integer::intValue).sum();

	System.out.println("\n=== THONG KE TONG QUAT ===");
	System.out.println("Tong so luong nhap: " + totalImported);
	System.out.println("Tong so luong ban: " + totalSold);
	System.out.printf("Tong doanh thu (ban): %.2f\n", totalRevenue);
	System.out.printf("Tong chi phi nhap: %.2f\n", totalImportCost);
	System.out.printf("Gia von hang ban (COGS): %.2f\n", costOfGoodsSold);
	System.out.printf("Loi nhuan gop (doanh thu - COGS): %.2f\n", (totalRevenue - costOfGoodsSold));

		// Per-product breakdown
		Set<String> products = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		products.addAll(imported.keySet());
		products.addAll(sold.keySet());
		// include products from catalog
		for (SanPham sp : ql.getDsSanPham()) products.add(sp.getTenSP());

	System.out.println("\nChi tiet theo san pham:");
	System.out.printf("%-30s %-10s %-10s %-10s\n", "San pham", "Nhap", "Ban", "Ton kho");
		for (String name : products) {
			int in = imported.getOrDefault(name, 0);
			int out = sold.getOrDefault(name, 0);
			int stock = findStock(ql, name);
			System.out.printf("%-30s %-10d %-10d %-10d\n", name, in, out, stock);
		}
		System.out.println();
	}

	private static double findGiaNhap(QuanLyCuaHang ql, String name) {
		for (SanPham sp : ql.getDsSanPham()) {
			if (sp.getTenSP().equalsIgnoreCase(name)) return sp.getGiaNhap();
		}
		return 0.0;
	}

	private static void parseChiTietAndAdd(String ct, Map<String, Integer> map) {
		if (ct == null) return;
		String[] items = ct.split(";");
		Pattern p = Pattern.compile("(.*) x(\\d+)");
		for (String it : items) {
			String s = it.trim();
			if (s.isEmpty()) continue;
			Matcher m = p.matcher(s);
			if (m.matches()) {
				String name = m.group(1).trim();
				int qty = Integer.parseInt(m.group(2));
				map.merge(name, qty, Integer::sum);
			} else {
				// try to parse trailing number
				int lastSpace = s.lastIndexOf(' ');
				if (lastSpace > 0 && lastSpace < s.length()-1) {
					try {
						int qty = Integer.parseInt(s.substring(lastSpace+1).trim());
						String name = s.substring(0, lastSpace).trim();
						map.merge(name, qty, Integer::sum);
					} catch (NumberFormatException ex) {
						// ignore
					}
				}
			}
		}
	}

	private static int findStock(QuanLyCuaHang ql, String name) {
		for (SanPham sp : ql.getDsSanPham()) {
			if (sp.getTenSP().equalsIgnoreCase(name)) return sp.getSoLuong();
		}
		return 0;
	}
}
