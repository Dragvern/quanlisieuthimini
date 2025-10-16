package quanlisieuthimini.control;

public interface  QuanLy<T> {
    void them(T t);
    void sua(String maHang, T t);
    void xoa(String maHang);
    T timKiem(String maHang);
    void hienThi();
    
}
