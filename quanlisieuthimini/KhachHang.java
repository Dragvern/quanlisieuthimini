import java.io.Serializable;

public class KhachHang extends Nguoi implements Serializable {
    private String diaChi;

    public KhachHang() {}

    public KhachHang(String ma, String hoTen, String sdt, String diaChi) {
        super(ma, hoTen, sdt);
        this.diaChi = diaChi;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap dia chi: ");
        diaChi = new java.util.Scanner(System.in).nextLine();
    }

    @Override
    public void xuat() {
        System.out.printf("Ma KH: %s | Ten: %s | SDT: %s | Dia chi: %s\n", ma, hoTen, sdt, diaChi);
    }

    @Override
    public String toFileString() {
        return super.toFileString() + ";" + diaChi;
    }

    @Override
    public String toString() {
        return String.format("Ma KH: %s | Ten: %s | SDT: %s | Dia chi: %s", ma, hoTen, sdt, diaChi);
    }
}
