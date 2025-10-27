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
            if (sp.getMaSP().equalsIgnoreCase(ma)) return sp;
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
        } catch (Exception e) {}
    }

    public void ghiSanPham() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sanpham.txt"))) {
            for (SanPham sp : dsSanPham) {
                bw.write(sp.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {}
    }

    // Ghi log nhap hang
    public void ghiNhapHang(SanPham sp, int soLuong) {
        try (FileWriter fw = new FileWriter("nhaphang.txt", true)) {
            String ngay = LocalDate.now().toString();
            fw.write(ngay + " | " + sp.getMaSP() + " | " + sp.getTenSP() + " | +" + soLuong + "\n");
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
        for (NhapHang pn : dsPhieuNhap) System.out.println(pn);
    }

    public void xoaPhieuNhap(String ma) {
        if (ma == null) return;
        String m = ma.trim();
        dsPhieuNhap.removeIf(pn -> pn != null && pn.getMaPN() != null && pn.getMaPN().trim().equalsIgnoreCase(m));
        ghiPhieuNhap();
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
                    String ngay = p[p.length-1].trim();
                    String tslStr = p[p.length-2].trim();
                    // join tokens 2 .. p.length-3 as chiTiet
                    StringBuilder sb = new StringBuilder();
                    for (int i = 2; i < p.length-2; i++) {
                        if (p[i] != null && !p[i].trim().isEmpty()) {
                            if (sb.length() > 0) sb.append(";");
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
        } catch (Exception e) {}
    }

    public void ghiPhieuNhap() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("phieunhap.txt"))) {
            for (NhapHang pn : dsPhieuNhap) {
                bw.write(pn.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {}
    }

    // ===== Getters for statistics / external use =====
    public List<SanPham> getDsSanPham() { return Collections.unmodifiableList(dsSanPham); }
    public List<HoaDon> getDsHoaDon() { return Collections.unmodifiableList(dsHoaDon); }
    public List<NhapHang> getDsPhieuNhap() { return Collections.unmodifiableList(dsPhieuNhap); }

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
        for (KhachHang kh : dsKhachHang) System.out.println(kh);
    }

    public void xoaKhachHang(String ma) {
        dsKhachHang.removeIf(kh -> kh.getMa().equalsIgnoreCase(ma));
        ghiKhachHang();
    }

    public KhachHang timKhachHang(String ma) {
        if (ma == null) return null;
        String m = ma.trim();
        for (KhachHang kh : dsKhachHang) {
            if (kh == null || kh.getMa() == null) continue;
            if (kh.getMa().trim().equalsIgnoreCase(m)) return kh;
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
        } catch (Exception e) {}
    }

    public void ghiKhachHang() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("khachhang.txt"))) {
            for (KhachHang kh : dsKhachHang) {
                bw.write(kh.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {}
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
        for (NhanVien nv : dsNhanVien) System.out.println(nv);
    }

    public void xoaNhanVien(String ma) {
        dsNhanVien.removeIf(nv -> nv.getMa().equalsIgnoreCase(ma));
        ghiNhanVien();
    }

    public NhanVien timNhanVien(String ma) {
        if (ma == null) return null;
        String m = ma.trim();
        for (NhanVien nv : dsNhanVien) {
            if (nv == null || nv.getMa() == null) continue;
            if (nv.getMa().trim().equalsIgnoreCase(m)) return nv;
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
        } catch (Exception e) {}
    }

    public void ghiNhanVien() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhanvien.txt"))) {
            for (NhanVien nv : dsNhanVien) {
                bw.write(nv.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {}
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
        for (HoaDon hd : dsHoaDon) System.out.println(hd);
    }

    public void xoaHoaDon(String ma) {
        if (ma == null) return;
        String m = ma.trim();
        dsHoaDon.removeIf(hd -> hd != null && hd.getMaHD() != null && hd.getMaHD().trim().equalsIgnoreCase(m));
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
                    String tongTienStr = p[p.length-1].trim();
                    // join tokens 3 .. p.length-2 as chiTiet
                    StringBuilder sb = new StringBuilder();
                    for (int i = 3; i < p.length-1; i++) {
                        if (p[i] != null && !p[i].trim().isEmpty()) {
                            if (sb.length() > 0) sb.append(";");
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
        } catch (Exception e) {}
    }

    public void ghiHoaDon() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt"))) {
            for (HoaDon hd : dsHoaDon) {
                bw.write(hd.getMaHD() + ";" + hd.getMaKH() + ";" + hd.getMaNV() + ";" + hd.getChiTiet() + ";" + hd.getTongTien());
                bw.newLine();
            }
        } catch (Exception e) {}
    }
}
