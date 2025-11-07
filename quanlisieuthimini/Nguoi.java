import java.util.Scanner;

public abstract class Nguoi implements IThaoTacFile {
    protected String ma;
    protected String hoTen;
    protected String sdt;
    protected Scanner sc;

    public Nguoi() {
        sc = new Scanner(System.in);
    }

    public Nguoi(String ma, String hoTen, String sdt) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public void nhap() {
        System.out.print("Nhap ma: ");
        ma = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("Ma: %s | Ho ten: %s | SDT: %s\n", ma, hoTen, sdt);
    }

    public String getMa() { return ma; }
    public String getHoTen() { return hoTen; }
    public String getSdt() { return sdt; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String toFileString() {
        return ma + ";" + hoTen + ";" + sdt;
    }
}
