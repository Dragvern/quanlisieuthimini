# Dự án OOP Quản lý Cửa hàng Mini

## Tổng quan
Dự án quản lý cửa hàng mini được xây dựng bằng Java với các nguyên lý OOP cơ bản.

## Cấu trúc dự án

### 1. Interface
- **IFileManager.java**: Interface quản lý đọc/ghi file
  - `readFromFile()`: Đọc dữ liệu từ file
  - `writeToFile()`: Ghi dữ liệu vào file

### 2. Lớp Abstract
- **Nguoi.java**: Lớp abstract cha cho KhachHang và NhanVien
  - Thuộc tính static: `soLuongNguoi` (đếm số lượng người)
  - Hàm abstract: `nhapThongTin()`, `xuatThongTin()`, `tinhTien()`
  - Hàm thiết lập: `thietLapThongTinCoBan()`

### 3. Lớp kế thừa
- **KhachHang.java**: Kế thừa từ Nguoi
  - Thuộc tính: loaiKhachHang, diemTichLuy
  - Override các hàm abstract từ lớp cha
  - Tính tiền dựa trên loại khách hàng và điểm tích lũy

- **NhanVien.java**: Kế thừa từ Nguoi
  - Thuộc tính: chucVu, luongCoBan, heSoLuong, soNgayCong
  - Override các hàm abstract từ lớp cha
  - Tính lương thực lĩnh dựa trên chức vụ và ngày công

### 4. Lớp với đa hình
- **SanPham.java**: Lớp cha với đa hình
  - Thuộc tính static: `soLuongSanPham`
  - Hàm `tinhGiaSauGiam()` có thể override
  - Lớp con: `ThucPham`, `DoChoi`

### 5. Lớp quản lý mảng đối tượng
- **QuanLyCuaHang.java**: Implement IFileManager
  - Mảng đối tượng: `danhSachKhachHang[]`, `danhSachNhanVien[]`, `danhSachSanPham[]`
  - Thuộc tính static: `tenCuaHang`, `diaChiCuaHang`
  - Các chức năng: thêm, tìm kiếm, thống kê, đọc/ghi file

### 6. Lớp Main
- **Main.java**: Chương trình chính với menu điều khiển
  - Demo đa hình với mảng Nguoi và SanPham
  - Quản lý khách hàng, nhân viên, sản phẩm
  - Lưu/đọc dữ liệu từ file

## Các tính năng chính

### ✅ Yêu cầu đã đáp ứng:
1. **3 lớp đối tượng**: KhachHang, NhanVien, SanPham
2. **Đọc/ghi file**: Interface IFileManager với implement trong QuanLyCuaHang
3. **Interface**: IFileManager cho quản lý file
4. **Đa hình**: 
   - Mảng Nguoi chứa KhachHang và NhanVien
   - Mảng SanPham chứa ThucPham và DoChoi
5. **Kế thừa hợp lý**: KhachHang và NhanVien kế thừa từ Nguoi
6. **Hàm thiết lập**: `thietLapThongTinCoBan()`, `thietLapThongTinCuaHang()`
7. **Hàm abstract**: `nhapThongTin()`, `xuatThongTin()`, `tinhTien()`
8. **Lớp mảng đối tượng**: QuanLyCuaHang quản lý các mảng
9. **Thuộc tính static**: `soLuongNguoi`, `soLuongSanPham`, `tenCuaHang`, `diaChiCuaHang`

## Cách chạy chương trình

1. Compile tất cả file Java:
```bash
javac *.java
```

2. Chạy chương trình:
```bash
java Main
```

3. Sử dụng menu để:
   - Quản lý khách hàng, nhân viên, sản phẩm
   - Xem thống kê
   - Lưu/đọc dữ liệu
   - Demo đa hình

## Demo đa hình
Chương trình có chức năng demo đa hình (menu 7) để minh họa:
- Mảng Nguoi chứa cả KhachHang và NhanVien
- Mảng SanPham chứa cả ThucPham và DoChoi
- Các hàm được gọi đa hình dựa trên kiểu thực tế của đối tượng

## File dữ liệu
Chương trình tự động tạo các file:
- `khachhang.txt`: Lưu thông tin khách hàng
- `nhanvien.txt`: Lưu thông tin nhân viên  
- `sanpham.txt`: Lưu thông tin sản phẩm
