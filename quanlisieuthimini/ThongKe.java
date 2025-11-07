import java.util.*;
import java.util.regex.*;
import java.io.*;

public class ThongKe {
	public static void thongKe(QuanLyCuaHang ql) {
		// Tính tổng doanh thu
		double tongDoanhThu = 0;
		
		// Tính doanh thu từ hóa đơn
		for (HoaDon hd : ql.getDsHoaDon()) {
			tongDoanhThu += hd.getTongTien();
		}
		
		// Thu thập dữ liệu về số lượng nhập và bán cho từng sản phẩm
		Map<String, Integer> soLuongNhap = new HashMap<>(); // key = maSP
		Map<String, Integer> soLuongBan = new HashMap<>();   // key = maSP
		
		// Đọc số lượng nhập từ file nhaphang.txt (format: maPN | ngay | maSP | tenSP | +soLuong)
		try (BufferedReader br = new BufferedReader(new FileReader("nhaphang.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\|");
				if (parts.length >= 5) {
					String maSP = parts[2].trim();
					String slStr = parts[4].trim().replace("+", "");
					try {
						int soLuong = Integer.parseInt(slStr);
						soLuongNhap.merge(maSP, soLuong, Integer::sum);
					} catch (NumberFormatException e) {
						// Bỏ qua dòng lỗi
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Khong doc duoc file nhaphang.txt");
		}
		
		// Đếm số lượng bán từ hóa đơn (sử dụng tên sản phẩm)
		for (HoaDon hd : ql.getDsHoaDon()) {
			String chiTiet = hd.getChiTiet();
			parseChiTietHoaDon(chiTiet, soLuongBan, ql);
		}
		
		// Tính tiền vốn và lợi nhuận dựa trên sản phẩm đã bán
		double tongTienVon = 0;
		for (SanPham sp : ql.getDsSanPham()) {
			String maSP = sp.getMaSP();
			int slBan = soLuongBan.getOrDefault(maSP, 0);
			tongTienVon += sp.getGiaNhap() * slBan; // Vốn = giá nhập × số lượng đã bán
		}
		
		// Lợi nhuận = Doanh thu - Vốn (của hàng đã bán)
		double loiNhuan = tongDoanhThu - tongTienVon;

		// Hiển thị thống kê tổng quan
		System.out.println("\n========== THONG KE TONG QUAT ==========");
		System.out.println("Tong so san pham: " + ql.getDsSanPham().size());
		System.out.println("Tong so khach hang: " + ql.getDsKhachHang().size());
		System.out.println("Tong so nhan vien: " + ql.getDsNhanVien().size());
		System.out.println("Tong so hoa don: " + ql.getDsHoaDon().size());
		System.out.printf("Tong tien von (hang da ban): %,.0f VND\n", tongTienVon);
		System.out.printf("Tong doanh thu: %,.0f VND\n", tongDoanhThu);
		System.out.printf("Loi nhuan: %,.0f VND\n", loiNhuan);
		
		// Thống kê sản phẩm
		System.out.println("\n========== THONG KE SAN PHAM ==========");
		System.out.printf("%-10s %-30s %-12s %-12s %-12s\n", 
			"Ma SP", "Ten SP", "SL Nhap", "SL Ban", "Ton Kho");
		System.out.println("--------------------------------------------------------------------------------");
		
		for (SanPham sp : ql.getDsSanPham()) {
			String maSP = sp.getMaSP();
			String tenSP = sp.getTenSP();
			int slNhap = soLuongNhap.getOrDefault(maSP, 0);
			int slBan = soLuongBan.getOrDefault(maSP, 0);
			int tonKho = sp.getSoLuong();
			
			System.out.printf("%-10s %-30s %-12d %-12d %-12d\n", 
				maSP, tenSP, slNhap, slBan, tonKho);
		}
		System.out.println("==========================================\n");
	}
	
	// Phương thức phân tích chi tiết hóa đơn (dùng tên sản phẩm) và chuyển sang mã SP
	private static void parseChiTietHoaDon(String chiTiet, Map<String, Integer> map, QuanLyCuaHang ql) {
		if (chiTiet == null || chiTiet.trim().isEmpty()) return;
		
		// Xử lý format: "Banh quy x10; Nuoc ngot x5;"
		String[] items = chiTiet.split(";");
		Pattern pattern = Pattern.compile("(.+?)\\s*x\\s*(\\d+)", Pattern.CASE_INSENSITIVE);
		
		for (String item : items) {
			String s = item.trim();
			if (s.isEmpty()) continue;
			
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				String tenSP = matcher.group(1).trim();
				int soLuong = Integer.parseInt(matcher.group(2));
				
				// Tìm mã sản phẩm từ tên sản phẩm
				String maSP = findMaSPByTen(ql, tenSP);
				if (maSP != null) {
					map.merge(maSP, soLuong, Integer::sum);
				}
			}
		}
	}
	
	// Tìm mã sản phẩm từ tên sản phẩm
	private static String findMaSPByTen(QuanLyCuaHang ql, String tenSP) {
		for (SanPham sp : ql.getDsSanPham()) {
			if (sp.getTenSP().equalsIgnoreCase(tenSP)) {
				return sp.getMaSP();
			}
		}
		return null;
	}
}
