package Entity_Class;

public class DocGia {

    private String maDG;
    private String tenDG;
    private String diaChi;
    private boolean gioiTinh;
    private String dienThoai;

    public DocGia() {
    }

    public DocGia(String maDG, String tenDG, String diaChi, boolean gioiTinh, String dienThoai) {
        this.maDG = maDG;
        this.tenDG = tenDG;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
}

