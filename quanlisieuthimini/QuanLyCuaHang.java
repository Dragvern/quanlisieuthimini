import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuanLyCuaHang {
    private final ArrayList<SanPham> dsSanPham;
    private final ArrayList<KhachHang> dsKhachHang;
    private final ArrayList<NhanVien> dsNhanVien;
    private final ArrayList<HoaDon> dsHoaDon;
    private final ArrayList<NhapHang> dsPhieuNhap;

    public QuanLyCuaHang() {
        dsSanPham = new ArrayList<>();
        dsKhachHang = new ArrayList<>();
        dsNhanVien = new ArrayList<>();
        dsHoaDon = new ArrayList<>();
        dsPhieuNhap = new ArrayList<>();
        docSanPham();
        docKhachHang();
        docNhanVien();
        docHoaDon();
        docPhieuNhap();
    }

    // ================== SAN PHAM ==================
    public void themSanPham(SanPham sp) {
        dsSanPham.add(sp);
        ghiSanPham();
    }

    public void hienThiSanPham() {
        if (dsSanPham.isEmpty()) {
            System.out.println("Chua co san pham nao!");
            return;
        }
        for (SanPham sp : dsSanPham) {
            System.out.println(sp);
        }
    }

    public void xoaSanPham(String ma) {
        dsSanPham.removeIf(sp -> sp.getMaSP().equalsIgnoreCase(ma));
        ghiSanPham();
    }

    public void suaSanPham(String ma, SanPham spMoi) {
        for (int i = 0; i < dsSanPham.size(); i++) {
            if (dsSanPham.get(i).getMaSP().equalsIgnoreCase(ma)) {
                dsSanPham.set(i, spMoi);
                ghiSanPham();
                return;
            }
        }
    }

    public SanPham timSanPhamTheoMa(String ma) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSP().equalsIgnoreCase(ma))
                return sp;
        }
        return null;
    }

    public void docSanPham() {
        try (BufferedReader br = new BufferedReader(new FileReader("sanpham.txt"))) {
            dsSanPham.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length >= 6) {
                    // ma;ten;giaNhap;giaBan;soLuong;loai
                    String m = p[0].trim();
                    String t = p[1].trim();
                    String gn = p[2].trim();
                    String gb = p[3].trim();
                    String s = p[4].trim();
                    String l = p[5].trim();
                    try {
                        double giaNhap = Double.parseDouble(gn);
                        double giaBan = Double.parseDouble(gb);
                        int soLuong = Integer.parseInt(s);
                        if (l.equalsIgnoreCase("Thuc pham")) {
                            dsSanPham.add(new ThucPham(m, t, giaNhap, giaBan, soLuong));
                        } else {
                            dsSanPham.add(new DoChoi(m, t, giaNhap, giaBan, soLuong));
                        }
                    } catch (NumberFormatException ex) {
                        // skip malformed line
                    }
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void ghiSanPham() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sanpham.txt"))) {
            for (SanPham sp : dsSanPham) {
                bw.write(sp.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

    // Ghi log nhap hang chi tiet (co lien ket voi phieu nhap)
    public void ghiNhapHang(String maPN, SanPham sp, int soLuong) {
        try (FileWriter fw = new FileWriter("nhaphang.txt", true)) {
            String ngay = LocalDate.now().toString();
            // Format: maPN | ngay | maSP | tenSP | +soLuong
            fw.write(maPN + " | " + ngay + " | " + sp.getMaSP() + " | " + sp.getTenSP() + " | +" + soLuong + "\n");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file nhaphang.txt: " + e.getMessage());
        }
    }

    // ================== PHIEU NHAP ==================
    public void themPhieuNhap(NhapHang pn) {
        dsPhieuNhap.add(pn);
        ghiPhieuNhap();
    }

    public void hienThiPhieuNhap() {
        if (dsPhieuNhap.isEmpty()) {
            System.out.println("Chua co phieu nhap nao!");
            return;
        }
        for (NhapHang pn : dsPhieuNhap)
            System.out.println(pn);
    }

    public void xoaPhieuNhap(String ma) {
        if (ma == null)
            return;
        // Đọc file nhaphang.txt để tìm các sản phẩm cần trả lại số lượng
        try (BufferedReader br = new BufferedReader(new FileReader("nhaphang.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    String maPN = parts[0].trim();
                    if (maPN.equalsIgnoreCase(ma.trim())) {
                        // Tìm thấy dòng thuộc phiếu nhập cần xóa
                        String maSP = parts[2].trim();
                        String slStr = parts[4].trim().replace("+", "");
                        try {
                            int soLuong = Integer.parseInt(slStr);
                            // Trừ số lượng sản phẩm (vì khi nhập đã cộng, giờ xóa phải trừ lại)
                            SanPham sp = timSanPhamTheoMa(maSP);
                            if (sp != null) {
                                sp.setSoLuong(sp.getSoLuong() - soLuong);
                                System.out.println("Da tru " + soLuong + " cua " + sp.getTenSP());
                            }
                        } catch (Exception e) {
                            // Bỏ qua dòng lỗi
                        }
                    }
               }
            }
            br.close();
        } catch (Exception e) {
        }
        
        // Cập nhật lại file sanpham.txt
        ghiSanPham();
        
        // Xóa các dòng trong nhaphang.txt có mã phiếu nhập này
        xoaNhapHangTheoMaPN(ma.trim());
        
        // Xóa phiếu nhập khỏi danh sách
        dsPhieuNhap.removeIf(pn -> pn != null && pn.getMaPN() != null && pn.getMaPN().trim().equalsIgnoreCase(ma.trim()));
        ghiPhieuNhap();
    }
    
    // Phương thức xóa các dòng trong nhaphang.txt theo mã phiếu nhập
    private void xoaNhapHangTheoMaPN(String maPN) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("nhaphang.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 1) {
                    String ma = parts[0].trim();
                    // Chỉ giữ lại các dòng KHÔNG phải mã phiếu nhập cần xóa
                    if (!ma.equalsIgnoreCase(maPN)) {
                        lines.add(line);
                    }
                }
            }
        } catch (Exception e) {
        }
        
        // Ghi lại file nhaphang.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhaphang.txt"))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

    public void docPhieuNhap() {
        try (BufferedReader br = new BufferedReader(new FileReader("phieunhap.txt"))) {
            dsPhieuNhap.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length >= 4) {
                    // maPN;maNV;chiTiet(may have ; inside)...;tongSoLuong;ngay
                    String maPN = p[0].trim();
                    String maNV = p[1].trim();
                    String ngay = p[p.length - 1].trim();
                    String tslStr = p[p.length - 2].trim();
                    // join tokens 2 .. p.length-3 as chiTiet
                    StringBuilder sb = new StringBuilder();
                    for (int i = 2; i < p.length - 2; i++) {
                        if (p[i] != null && !p[i].trim().isEmpty()) {
                            if (sb.length() > 0)
                                sb.append(";");
                            sb.append(p[i].trim());
                        }
                    }
                    String chiTiet = sb.toString();
                    try {
                        int tsl = Integer.parseInt(tslStr);
                        dsPhieuNhap.add(new NhapHang(maPN, maNV, chiTiet, tsl, ngay));
                    } catch (NumberFormatException ex) {
                        // skip malformed line
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void ghiPhieuNhap() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("phieunhap.txt"))) {
            for (NhapHang pn : dsPhieuNhap) {
                bw.write(pn.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

    // ===== Getters for statistics / external use =====
    public List<SanPham> getDsSanPham() {
        return Collections.unmodifiableList(dsSanPham);
    }

    public List<KhachHang> getDsKhachHang() {
        return Collections.unmodifiableList(dsKhachHang);
    }

    public List<NhanVien> getDsNhanVien() {
        return Collections.unmodifiableList(dsNhanVien);
    }

    public List<HoaDon> getDsHoaDon() {
        return Collections.unmodifiableList(dsHoaDon);
    }

    public List<NhapHang> getDsPhieuNhap() {
        return Collections.unmodifiableList(dsPhieuNhap);
    }

    public boolean kiemTraMaHDTrung(String ma) {
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMaHD().trim().equalsIgnoreCase(ma.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraMaPhieuNhapTrung(String ma) {
        for (NhapHang pn : dsPhieuNhap) {
            if (pn.getMaPN().trim().equalsIgnoreCase(ma.trim())) {
                return true;
            }
        }
        return false;
    }

    // ================== KHACH HANG ==================
    public void themKhachHang(KhachHang kh) {
        dsKhachHang.add(kh);
        ghiKhachHang();
    }

    public void hienThiKhachHang() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chua co khach hang nao!");
            return;
        }
        for (KhachHang kh : dsKhachHang)
            System.out.println(kh);
    }

    public void xoaKhachHang(String ma) {
        dsKhachHang.removeIf(kh -> kh.getMa().equalsIgnoreCase(ma));
        ghiKhachHang();
    }

    public KhachHang timKhachHang(String ma) {
        if (ma == null)
            return null;
        String m = ma.trim();
        for (KhachHang kh : dsKhachHang) {
            if (kh == null || kh.getMa() == null)
                continue;
            if (kh.getMa().trim().equalsIgnoreCase(m))
                return kh;
        }
        return null;
    }

    public void docKhachHang() {
        try (BufferedReader br = new BufferedReader(new FileReader("khachhang.txt"))) {
            dsKhachHang.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length >= 4) {
                    dsKhachHang.add(new KhachHang(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim()));
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void ghiKhachHang() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("khachhang.txt"))) {
            for (KhachHang kh : dsKhachHang) {
                bw.write(kh.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

    // ================== NHAN VIEN ==================
    public void themNhanVien(NhanVien nv) {
        dsNhanVien.add(nv);
        ghiNhanVien();
    }

    public void hienThiNhanVien() {
        if (dsNhanVien.isEmpty()) {
            System.out.println("Chua co nhan vien nao!");
            return;
        }
        for (NhanVien nv : dsNhanVien)
            System.out.println(nv);
    }

    public void xoaNhanVien(String ma) {
        dsNhanVien.removeIf(nv -> nv.getMa().equalsIgnoreCase(ma));
        ghiNhanVien();
    }

    public NhanVien timNhanVien(String ma) {
        if (ma == null)
            return null;
        String m = ma.trim();
        for (NhanVien nv : dsNhanVien) {
            if (nv == null || nv.getMa() == null)
                continue;
            if (nv.getMa().trim().equalsIgnoreCase(m))
                return nv;
        }
        return null;
    }

    public void docNhanVien() {
        try (BufferedReader br = new BufferedReader(new FileReader("nhanvien.txt"))) {
            dsNhanVien.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length >= 4) {
                    dsNhanVien.add(new NhanVien(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim()));
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void ghiNhanVien() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhanvien.txt"))) {
            for (NhanVien nv : dsNhanVien) {
                bw.write(nv.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

    // ================== HOA DON ==================
    public void themHoaDon(HoaDon hd) {
        dsHoaDon.add(hd);
        ghiHoaDon();
    }

    public void hienThiHoaDon() {
        if (dsHoaDon.isEmpty()) {
            System.out.println("Chua co hoa don nao!");
            return;
        }
        for (HoaDon hd : dsHoaDon)
            System.out.println(hd);
    }

    public HoaDon timHoaDon(String ma) {
        if (ma == null) return null;
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMaHD().equalsIgnoreCase(ma.trim())) {
                return hd;
            }
        }
        return null;
    }

    public void xoaHoaDon(String ma) {
        if (ma == null) return;
        
        // Tìm hóa đơn cần xóa
        HoaDon hoaDonCanXoa = null;
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMaHD().equalsIgnoreCase(ma.trim())) {
                hoaDonCanXoa = hd;
                break;
            }
        }
        
        // Nếu tìm thấy, hoàn lại số lượng sản phẩm
        if (hoaDonCanXoa != null) {
            String chiTiet = hoaDonCanXoa.getChiTiet();  // "Ban bong x3;Qua mit x5;"
            String[] dsSanPhamBan = chiTiet.split(";");   // ["Ban bong x3", "Qua mit x5"]
            
            for (String item : dsSanPhamBan) {
                if (item.trim().isEmpty()) continue;
                
                // Tách "Ban bong x3" thành tên="Ban bong" và số lượng=3
                int viTriX = item.toLowerCase().lastIndexOf(" x");
                if (viTriX > 0) {
                    String tenSP = item.substring(0, viTriX).trim();
                    String soLuongStr = item.substring(viTriX + 2).trim();
                    
                    try {
                        int soLuong = Integer.parseInt(soLuongStr);
                        
                        // Tìm sản phẩm và cộng lại số lượng
                        for (SanPham sp : dsSanPham) {
                            if (sp.getTenSP().equalsIgnoreCase(tenSP)) {
                                sp.setSoLuong(sp.getSoLuong() + soLuong);
                                System.out.println("Da hoan " + soLuong + " cua " + tenSP);
                                break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        // Bỏ qua nếu format sai
                    }
                }
            }
            
            // Cập nhật file sản phẩm
            ghiSanPham();
        }
        
        // Xóa hóa đơn
        dsHoaDon.removeIf(hd -> hd.getMaHD().equalsIgnoreCase(ma.trim()));
        ghiHoaDon();
    }

    public void docHoaDon() {
        try (BufferedReader br = new BufferedReader(new FileReader("hoadon.txt"))) {
            dsHoaDon.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length >= 5) {
                    // maHD;maKH;maNV;chiTiet(may have ; inside);...;tongTien
                    String maHD = p[0].trim();
                    String maKH = p[1].trim();
                    String maNV = p[2].trim();
                    String tongTienStr = p[p.length - 1].trim();
                    // join tokens 3 .. p.length-2 as chiTiet
                    StringBuilder sb = new StringBuilder();
                    for (int i = 3; i < p.length - 1; i++) {
                        if (p[i] != null && !p[i].trim().isEmpty()) {
                            if (sb.length() > 0)
                                sb.append(";");
                            sb.append(p[i].trim());
                        }
                    }
                    String chiTiet = sb.toString();
                    try {
                        double tongTien = Double.parseDouble(tongTienStr);
                        dsHoaDon.add(new HoaDon(maHD, maKH, maNV, chiTiet, tongTien));
                    } catch (NumberFormatException ex) {
                        // skip malformed line
                    }
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void ghiHoaDon() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt"))) {
            for (HoaDon hd : dsHoaDon) {
                bw.write(hd.getMaHD() + ";" + hd.getMaKH() + ";" + hd.getMaNV() + ";" + hd.getChiTiet() + ";"
                        + hd.getTongTien());
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }
}
