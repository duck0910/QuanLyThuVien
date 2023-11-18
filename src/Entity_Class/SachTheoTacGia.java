package Entity_Class;

public class SachTheoTacGia {

    private String MaTG;
    private String MaSach;

    public SachTheoTacGia() {
    }

    public SachTheoTacGia(String MaTG, String MaSach) {
        this.MaTG = MaTG;
        this.MaSach = MaSach;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }
}
