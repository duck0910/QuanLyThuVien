package Entity_Class;


import java.util.Date;

public class Sach {
    private String MaSach;
    private String TenSach;
    private String MaNXB;
    private String MaTL;
    private int SoLuong;
    private Date NgayNhap;
    private String ViTri;
    private String Hinh;

    public Sach() {
    }

    public Sach(String MaSach, String TenSach, String MaNXB, String MaTL, int SoLuong, Date NgayNhap, String ViTri, String Hinh) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.MaNXB = MaNXB;
        this.MaTL = MaTL;
        this.SoLuong = SoLuong;
        this.NgayNhap = NgayNhap;
        this.ViTri = ViTri;
        this.Hinh = Hinh;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
}
