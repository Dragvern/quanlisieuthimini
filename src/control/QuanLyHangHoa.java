package quanlisieuthimini.control;

import model.HangHoa;
import java.ultil.ArrayList;


public class QuanLyHangHoa implements QuanLy<HangHoa> {
    private ArrayList<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        this.danhSachHangHoa = new ArrayList<>();
    }

    @Override
    public void them(HangHoa hangHoa) {
        danhSachHangHoa.add(hangHoa);
    }

    @Override
    public void sua(String maHang, HangHoa hangHoa) {
        for (int i = 0; i < danhSachHangHoa.size(); i++) {
            if (danhSachHangHoa.get(i).getMaHang().equals(maHang)) {
                danhSachHangHoa.set(i, hangHoa);
                return;
            }
        }
    }

    @Override
    public void xoa(String maHang) {
        danhSachHangHoa.removeIf(hangHoa -> hangHoa.getMaHang().equals(maHang));
    }

    @Override
    public HangHoa timKiem(String maHang) {
        for (HangHoa hangHoa : danhSachHangHoa) {
            if (hangHoa.getMaHang().equals(maHang)) {
                return hangHoa;
            }
        }
        return null;
    }

    @Override
    public void hienThi() {
        for (HangHoa hangHoa : danhSachHangHoa) {
            System.out.println(hangHoa);
        }
    }
    
}
