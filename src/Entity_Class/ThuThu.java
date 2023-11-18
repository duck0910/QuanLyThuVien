package Entity_Class;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VTOS
 */
public class ThuThu {
    private String maThuThu;
    private String tenThuThu;
    private String matKhau;
    private boolean vaiTro;

    public ThuThu() {
    }

    public ThuThu(String maThuThu, String tenThuThu, String matKhau, boolean vaiTro) {
        this.maThuThu = maThuThu;
        this.tenThuThu = tenThuThu;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public String getTenThuThu() {
        return tenThuThu;
    }

    public void setTenThuThu(String tenThuThu) {
        this.tenThuThu = tenThuThu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
}

