
public class NhanVien extends Nguoi {
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String ma, String hoTen, String sdt, String chucVu) {
        super(ma, hoTen, sdt);
        this.chucVu = chucVu;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap chuc vu: ");
        chucVu = sc.nextLine();
    }

    @Override
    public void xuat() {
        System.out.printf("Ma NV: %s | Ten: %s | SDT: %s | Chuc vu: %s\n", ma, hoTen, sdt, chucVu);
    }

    @Override
    public String toFileString() {
        return super.toFileString() + ";" + chucVu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return String.format("Ma NV: %s | Ten: %s | SDT: %s | Chuc vu: %s", ma, hoTen, sdt, chucVu);
    }
}
