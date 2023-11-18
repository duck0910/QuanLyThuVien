/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Class;

import java.util.Date;

/**
 *
 * @author VTOS
 */
public class PhieuMuon {

    private int maPM;
    private String maDG;
    private String maSach;
    private Date ngayMuon;
    private Date ngayTra;
    private String maThuThu;
    private boolean tinhTrang;

    public PhieuMuon() {
    }

    public PhieuMuon(int maPM, String maDG, String maSach, Date ngayMuon, Date ngayTra, String maThuThu, boolean tinhTrang) {
        this.maPM = maPM;
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.maThuThu = maThuThu;
        this.tinhTrang = tinhTrang;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
