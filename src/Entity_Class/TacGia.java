package Entity_Class;

import java.util.Date;

public class TacGia {

    private String maTG;
    private String tenTG;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String email;

    public TacGia() {
    }

    public TacGia(String maTG, String tenTG, boolean gioiTinh, Date ngaySinh, String email) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}