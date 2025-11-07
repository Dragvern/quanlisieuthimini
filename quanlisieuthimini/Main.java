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

    

    static void menuSanPham(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY SAN PHAM ---");
            System.out.println("1. Them");
            System.out.println("2. Tim");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("5. Xem danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    String ma;
                    do {
                        System.out.print("Ma SP: ");
                        ma = sc.nextLine();
                        if (ql.timSanPhamTheoMa(ma) != null) {
                            System.out.println("*** Ma san pham da ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timSanPhamTheoMa(ma) != null);

                    System.out.print("Ten: "); String ten = sc.nextLine();
                    System.out.print("Gia nhap (gia mua): "); double giaNhap = Double.parseDouble(sc.nextLine());
                    System.out.print("Gia ban: "); double giaBan = Double.parseDouble(sc.nextLine());
                    System.out.print("Loai SP (1-Thuc pham, 2-Do choi): "); 
                    int loai = Integer.parseInt(sc.nextLine());
                    if (loai == 1) {
                        ql.themSanPham(new ThucPham(ma, ten, giaNhap, giaBan, 0 ));
                    } else {
                        ql.themSanPham(new DoChoi(ma, ten, giaNhap, giaBan, 0 ));
                    }
                    System.out.println("Da them san pham thanh cong!");
                }
                case 2 -> {
                    String ma;
                    do {
                        System.out.print("Ma SP can tim: ");
                        ma = sc.nextLine();
                        if (ql.timSanPhamTheoMa(ma) == null) {
                            System.out.println("*** Ma san pham khong ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timSanPhamTheoMa(ma) == null);
                    ql.timSanPhamTheoMa(ma).xuat();
                }
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
                case 5 -> ql.hienThiSanPham();
            }
        } while (c != 0);
    }

    static void menuKhachHang(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY KHACH HANG ---");
            System.out.println("1. Them");
            System.out.println("2. Tim ");
            System.out.println("3. Xoa");
            System.out.println("4. Sua");
            System.out.println("5. Xem danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    String ma;
                    do {
                        System.out.print("Ma KH: ");
                        ma = sc.nextLine();
                        if (ql.timKhachHang(ma) != null) {
                            System.out.println("*** Ma khach hang da ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timKhachHang(ma) != null);
                    System.out.print("Ho ten: "); String ten = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Dia chi: "); String dc = sc.nextLine();
                    ql.themKhachHang(new KhachHang(ma, ten, sdt, dc));
                }
                case 2 -> {
                    String ma;
                    do {
                        System.out.print("Ma KH can xem: ");
                        ma = sc.nextLine();
                        if (ql.timKhachHang(ma) == null) {
                            System.out.println("*** Ma khach hang khong ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timKhachHang(ma) == null);
                    ql.timKhachHang(ma).xuat();
                }
                case 3 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ql.xoaKhachHang(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Nhap ma can sua: ");
                    String ma = sc.nextLine();
                    KhachHang kh = ql.timKhachHang(ma);
                    if (kh != null) {
                        System.out.print("Ten moi: "); kh.setHoTen(sc.nextLine());
                        System.out.print("SDT moi: "); kh.setSdt(sc.nextLine());
                        System.out.print("Dia chi moi: "); kh.setDiaChi(sc.nextLine());
                        ql.ghiKhachHang();
                        System.out.println("Da cap nhat thong tin khach hang!");
                    } else {
                        System.out.println("Khong tim thay khach hang!");
                    }
                }
                case 5 -> ql.hienThiKhachHang();
            }
        } while (c != 0);
    }

    static void menuNhanVien(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY NHAN VIEN ---");
            System.out.println("1. Them");
            System.out.println("2. Tim");
            System.out.println("3. Xoa");
            System.out.println("4. Sua");
            System.out.println("5. Xem danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1 -> {
                    String ma;
                    do {
                        System.out.print("Ma NV: ");
                        ma = sc.nextLine();
                        if (ql.timNhanVien(ma) != null) {
                            System.out.println("*** Ma nhan vien da ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timNhanVien(ma) != null);
                    System.out.print("Ho ten: "); String ten = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Chuc vu: "); String chucVu = sc.nextLine();
                    ql.themNhanVien(new NhanVien(ma, ten, sdt, chucVu));
                }
                case 2 -> {
                    String ma;
                    do {
                        System.out.print("Ma NV can tim: ");
                        ma = sc.nextLine();
                        if (ql.timNhanVien(ma) == null) {
                            System.out.println("*** Ma nhan vien khong ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.timNhanVien(ma) == null);
                    ql.timNhanVien(ma).xuat();
                }
                case 3 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ql.xoaNhanVien(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Nhap ma can sua: ");
                    String ma = sc.nextLine();
                    NhanVien nv = ql.timNhanVien(ma);
                    if (nv != null) {
                        System.out.print("Ten moi: "); nv.setHoTen(sc.nextLine());
                        System.out.print("SDT moi: "); nv.setSdt(sc.nextLine());
                        System.out.print("Chuc vu moi: "); nv.setChucVu(sc.nextLine());
                        ql.ghiNhanVien();
                        System.out.println("Da cap nhat thong tin nhan vien!");
                    } else {
                        System.out.println("Khong tim thay nhan vien!");
                    }
                }
                case 5 -> ql.hienThiNhanVien();
            }
        } while (c != 0);
    }

    static void menuHoaDon(QuanLyCuaHang ql, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- QUAN LY HOA DON ---");
            System.out.println("1. Tao hoa don moi");
            System.out.println("2. Tim hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Xem danh sach hoa don");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> taoHoaDonMoi(ql, sc);
                case 2 -> {
                    System.out.print("Ma HD can tim: ");
                    String ma = sc.nextLine();
                    HoaDon hd = ql.timHoaDon(ma);
                    if (hd != null) {
                        System.out.println(hd);
                    } else {
                        System.out.println("Khong tim thay hoa don!");
                    }
                }
                case 3 -> {
                    System.out.print("Nhap ma HD can xoa: ");
                    String maXoa = sc.nextLine().trim();
                    ql.xoaHoaDon(maXoa);
                    System.out.println("[V] Da xoa (neu ton tai)!");
                }
                case 4 -> ql.hienThiHoaDon();
            }
        } while (c != 0);
    }

    static void taoHoaDonMoi(QuanLyCuaHang ql, Scanner sc) {
        // Bước 1: Nhập mã hóa đơn
        String maHD;
        do {
            System.out.print("Ma HD: ");
            maHD = sc.nextLine();
            if (ql.kiemTraMaHDTrung(maHD)) {
                System.out.println("*** Ma hoa don da ton tai! Vui long nhap ma khac. ***");
            }
        } while (ql.kiemTraMaHDTrung(maHD));
        
        // Bước 2: Nhập và kiểm tra khách hàng, nhân viên
        System.out.print("Ma KH: "); 
        String maKH = sc.nextLine().trim();
        System.out.print("Ma NV: "); 
        String maNV = sc.nextLine().trim();

        KhachHang kh = ql.timKhachHang(maKH);
        NhanVien nv = ql.timNhanVien(maNV);
        if (kh == null || nv == null) {
            System.out.println("Ma KH hoac NV khong ton tai!");
            return;
        }

        // Bước 3: Chọn sản phẩm
        double tongTien = 0;
        StringBuilder chiTiet = new StringBuilder();
        String tiep;
        
        do {
            ql.hienThiSanPham();
            System.out.print("Nhap ma SP: ");
            String maSP = sc.nextLine().trim();
            SanPham sp = ql.timSanPhamTheoMa(maSP);
            
            if (sp == null) {
                System.out.println("Khong tim thay SP!");
                System.out.print("Them san pham khac? (y/n): ");
                tiep = sc.nextLine();
                continue;
            }
            
            System.out.print("So luong: ");
            int sl = Integer.parseInt(sc.nextLine());
            
            if (sl > sp.getSoLuong()) {
                System.out.println("Khong du hang! Ton kho: " + sp.getSoLuong());
                System.out.print("Them san pham khac? (y/n): ");
                tiep = sc.nextLine();
                continue;
            }
            
            // Cập nhật số lượng và tính tiền
            sp.setSoLuong(sp.getSoLuong() - sl);
            tongTien += sp.getGiaBan() * sl;
            chiTiet.append(sp.getTenSP()).append(" x").append(sl).append(";");
            
            System.out.print("Them san pham khac? (y/n): ");
            tiep = sc.nextLine();
        } while (tiep.equalsIgnoreCase("y"));

        // Bước 4: Lưu hóa đơn
        ql.ghiSanPham();
        HoaDon hd = new HoaDon(maHD, maKH, maNV, chiTiet.toString(), tongTien);
        ql.themHoaDon(hd);
        System.out.println("Tao hoa don thanh cong! Tong tien: " + String.format("%,.0f VND", tongTien));
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

    static void menuNhapHang(QuanLyCuaHang ql, Scanner sc) {
        System.out.println("=== NHAP HANG ===");
        String maPN;
                    do {
                        System.out.print("Ma phieu nhap: ");
                        maPN = sc.nextLine();
                        if (ql.kiemTraMaPhieuNhapTrung(maPN)) {
                            System.out.println("*** Ma phieu nhap da ton tai! Vui long nhap ma khac. ***");
                        }
                    } while (ql.kiemTraMaPhieuNhapTrung(maPN));
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
                ql.ghiNhapHang(maPN, sp, sl); // log chi tiet voi ma phieu
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
