import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuanLyCuaHang ql = new QuanLyCuaHang();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly nhan vien");
            System.out.println("4. Quan ly hoa don");
            System.out.println("5. Quan ly nhap hang");
            System.out.println("6. Thong ke");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> menuSanPham(ql, sc);
                case 2 -> menuKhachHang(ql, sc);
                case 3 -> menuNhanVien(ql, sc);
                case 4 -> menuHoaDon(ql, sc);
                case 5 -> menuQuanLyNhapHang(ql, sc);
                case 6 -> ThongKe.thongKe(ql);
            }
        } while (chon != 0);
    }

    static void menuQuanLyNhapHang(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY NHAP HANG ---");
            System.out.println("1. Tao phieu nhap");
            System.out.println("2. Xem phieu nhap");
            System.out.println("3. Xoa phieu nhap");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> menuNhapHang(ql, sc);
                case 2 -> ql.hienThiPhieuNhap();
                case 3 -> {
                    System.out.print("Nhap ma phieu can xoa: ");
                    String ma = sc.nextLine().trim();
                    ql.xoaPhieuNhap(ma);
                    System.out.println("[V] Da xoa (neu ton tai)!");
                }
            }
        } while (c != 0);
    }

    static void menuSanPham(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY SAN PHAM ---");
            System.out.println("1. Them");
            System.out.println("2. Xem");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    System.out.print("Ma: "); String ma = sc.nextLine();
                    System.out.print("Ten: "); String ten = sc.nextLine();
                    System.out.print("Gia nhap (gia mua): "); double giaNhap = Double.parseDouble(sc.nextLine());
                    System.out.print("Gia ban: "); double giaBan = Double.parseDouble(sc.nextLine());
                    System.out.print("So luong: "); int sl = Integer.parseInt(sc.nextLine());
                    System.out.print("Loai SP (1-Thuc pham, 2-Do choi): "); 
                    int loai = Integer.parseInt(sc.nextLine());
                    if (loai == 1) {
                        ql.themSanPham(new ThucPham(ma, ten, giaNhap, giaBan, sl));
                    } else {
                        ql.themSanPham(new DoChoi(ma, ten, giaNhap, giaBan, sl));
                    }
                }
                case 2 -> ql.hienThiSanPham();
                case 3 -> {
                    System.out.print("Nhap ma can sua: ");
                    String ma = sc.nextLine();
                    SanPham sp = ql.timSanPhamTheoMa(ma);
                    if (sp != null) {
                        System.out.print("Ten moi: "); sp.setTenSP(sc.nextLine());
                        System.out.print("Gia nhap moi: "); sp.setGiaNhap(Double.parseDouble(sc.nextLine()));
                        System.out.print("Gia ban moi: "); sp.setGiaBan(Double.parseDouble(sc.nextLine()));
                        System.out.print("SL moi: "); sp.setSoLuong(Integer.parseInt(sc.nextLine()));
                        ql.ghiSanPham();
                    }
                }
                case 4 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ql.xoaSanPham(sc.nextLine());
                }
            }
        } while (c != 0);
    }

    static void menuKhachHang(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY KHACH HANG ---");
            System.out.println("1. Them");
            System.out.println("2. Xem");
            System.out.println("3. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    System.out.print("Ma KH: "); String ma = sc.nextLine();
                    System.out.print("Ho ten: "); String ten = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Dia chi: "); String dc = sc.nextLine();
                    ql.themKhachHang(new KhachHang(ma, ten, sdt, dc));
                }
                case 2 -> ql.hienThiKhachHang();
                case 3 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ql.xoaKhachHang(sc.nextLine());
                }
            }
        } while (c != 0);
    }

    static void menuNhanVien(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY NHAN VIEN ---");
            System.out.println("1. Them");
            System.out.println("2. Xem");
            System.out.println("3. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    System.out.print("Ma NV: "); String ma = sc.nextLine();
                    System.out.print("Ho ten: "); String ten = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Chuc vu: "); String chucVu = sc.nextLine();
                    ql.themNhanVien(new NhanVien(ma, ten, sdt, chucVu));
                }
                case 2 -> ql.hienThiNhanVien();
                case 3 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ql.xoaNhanVien(sc.nextLine());
                }
            }
        } while (c != 0);
    }

    static void menuHoaDon(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY HOA DON ---");
            System.out.println("1. Tao hoa don moi");
            System.out.println("2. Xem danh sach hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());

            if (c == 1) {
                System.out.print("Ma HD: "); String maHD = sc.nextLine().trim();
                System.out.print("Ma KH: "); String maKH = sc.nextLine().trim();
                System.out.print("Ma NV: "); String maNV = sc.nextLine().trim();

                KhachHang kh = ql.timKhachHang(maKH);
                NhanVien nv = ql.timNhanVien(maNV);
                if (kh == null || nv == null) {
                    System.out.println("Ma KH hoac NV khong ton tai!");
                    continue;
                }

                double tongTien = 0;
                StringBuilder chiTiet = new StringBuilder();
                String tiep;
                do {
                    ql.hienThiSanPham();
                    System.out.print("Nhap ma SP: ");
                    String maSP = sc.nextLine().trim();
                    SanPham sp = ql.timSanPhamTheoMa(maSP);
                    if (sp != null) {
                        System.out.print("So luong: ");
                        int sl = Integer.parseInt(sc.nextLine());
                        if (sl <= sp.getSoLuong()) {
                            sp.setSoLuong(sp.getSoLuong() - sl);
                            double tien = sp.getGiaBan() * sl;
                            tongTien += tien;
                            chiTiet.append(sp.getTenSP()).append(" x").append(sl).append(";");
                } else System.out.println("Khong du hang!");
                    } else System.out.println("❌ Khong tim thay SP!");
            System.out.print("Them san pham khac? (y/n): ");
                    tiep = sc.nextLine();
                } while (tiep.equalsIgnoreCase("y"));

                ql.ghiSanPham();
                HoaDon hd = new HoaDon(maHD, maKH, maNV, chiTiet.toString(), tongTien);
                ql.themHoaDon(hd);
                System.out.println("Tao hoa don thanh cong!");
            } else if (c == 2) {
                ql.hienThiHoaDon();
            } else if (c == 3) {
                System.out.print("Nhap ma HD can xoa: ");
                String maXoa = sc.nextLine().trim();
                ql.xoaHoaDon(maXoa);
                System.out.println("[V] Da xoa (neu ton tai)!");
            }
        } while (c != 0);
    }

    static void menuNhapHang(QuanLyCuaHang ql, Scanner sc) {
        System.out.println("=== NHAP HANG ===");
        System.out.print("Ma phieu nhap: "); String maPN = sc.nextLine().trim();
        System.out.print("Ma NV thuc hien: "); String maNV = sc.nextLine().trim();
        NhanVien nv = ql.timNhanVien(maNV);
        if (nv == null) {
            System.out.println("[X] Ma NV khong ton tai, huy nhap hang.");
            return;
        }

        String tiep;
        StringBuilder chiTiet = new StringBuilder();
        int tongSoLuong = 0;
        do {
            ql.hienThiSanPham();
                System.out.print("Nhap ma san pham: ");
            String ma = sc.nextLine().trim();
            SanPham sp = ql.timSanPhamTheoMa(ma);
            if (sp != null) {
                System.out.print("Nhap so luong can nhap them: ");
                int sl = Integer.parseInt(sc.nextLine());
                sp.setSoLuong(sp.getSoLuong() + sl);
                ql.ghiNhapHang(sp, sl); // log
                chiTiet.append(sp.getTenSP()).append(" x").append(sl).append("; ");
                tongSoLuong += sl;
                System.out.println("[V] Da ghi nhap " + sl + " cua " + sp.getTenSP());
            } else {
                System.out.println("[X] Khong tim thay san pham!");
            }
            System.out.print("Nhap san pham khac? (y/n): ");
            tiep = sc.nextLine();
        } while (tiep.equalsIgnoreCase("y"));

        if (chiTiet.length() > 0) {
            ql.ghiSanPham();
            NhapHang pn = new NhapHang(maPN, maNV, chiTiet.toString(), tongSoLuong, java.time.LocalDate.now().toString());
            ql.themPhieuNhap(pn);
            System.out.println("[V] Hoan tat nhap hang. Phieu nhap da luu: " + maPN);
        } else {
            System.out.println("[!] Khong co san pham nao duoc nhap.");
        }
    }
}
