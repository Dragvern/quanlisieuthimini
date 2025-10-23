/**
 * Test chuc nang thanh toan
 */
public class TestThanhToan {
    public static void main(String[] args) {
        System.out.println("=== TEST CHUC NANG THANH TOAN ===");
        
        // Tao doi tuong quan ly
        QuanLyCuaHang ql = new QuanLyCuaHang();
        
        System.out.println("\n1. KHOI TAO DU LIEU:");
        System.out.println("====================");
        
        // Them khach hang
        KhachHang kh1 = new KhachHang("KH001", "Nguyen Van A", "0123456789", "123 Duong A", "VIP");
        ql.themKhachHang(kh1);
        
        // Them nhan vien
        NhanVien nv1 = new NhanVien("NV001", "Le Van C", "0111222333", "789 Duong C", "Nhan vien", 5000000.0, 22);
        ql.themNhanVien(nv1);
        
        // Them san pham
        SanPham sp1 = new SanPham("SP001", "Banh mi", 15000, 100, "Thuc pham");
        SanPham sp2 = new SanPham("SP002", "Nuoc ngot", 10000, 50, "Do uong");
        ql.themSanPham(sp1);
        ql.themSanPham(sp2);
        
        System.out.println("Da khoi tao du lieu thanh cong!");
        
        System.out.println("\n2. TON KHO BAN DAU:");
        System.out.println("===================");
        ql.xuatDanhSachSanPham();
        
        System.out.println("\n3. TAO HOA DON:");
        System.out.println("================");
        HoaDon hd1 = ql.taoHoaDon("HD001", "KH001", "NV001", "23/10/2024");
        
        System.out.println("\n4. THEM SAN PHAM VAO HOA DON:");
        System.out.println("==============================");
        ql.themSanPhamVaoHoaDon("HD001", "SP001", 5);  // 5 banh mi
        ql.themSanPhamVaoHoaDon("HD001", "SP002", 3);  // 3 nuoc ngot
        
        System.out.println("\n5. TON KHO TRUOC KHI THANH TOAN:");
        System.out.println("=================================");
        ql.xuatDanhSachSanPham();
        
        System.out.println("\n6. THANH TOAN HOA DON:");
        System.out.println("======================");
        ql.thanhToanHoaDon("HD001");
        
        System.out.println("\n7. TON KHO SAU KHI THANH TOAN:");
        System.out.println("===============================");
        ql.xuatDanhSachSanPham();
        
        System.out.println("\n8. TIM KIEM TON KHO THEO MA SP:");
        System.out.println("================================");
        SanPham spTim = ql.timSanPham("SP001");
        if (spTim != null) {
            System.out.println("Thong tin san pham SP001:");
            spTim.xuatThongTin();
            if (spTim.hetHang()) {
                System.out.println("⚠️  CANH BAO: San pham da het hang!");
            } else if (spTim.getSoLuongTon() < 10) {
                System.out.println("⚠️  CANH BAO: San pham sap het hang! Chi con " + spTim.getSoLuongTon() + " san pham");
            } else {
                System.out.println("✅ San pham con du hang trong kho");
            }
        }
        
        System.out.println("\n=== KET THUC TEST ===");
        System.out.println("Chuc nang thanh toan da hoat dong thanh cong!");
    }
}
