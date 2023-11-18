package DAO;

import Entity_Class.PhieuMuon;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO extends LibSysDAO<PhieuMuon, Integer> {
private static final String INSERT_SQL = "INSERT INTO [dbo].[PhieuMuon]([MaDG], [MaSach], [NgayMuon], [NgayTra], [MaThuThu], [TinhTrang]) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_SQL = "UPDATE [dbo].[PhieuMuon] SET [MaDG]=?, [MaSach]=?, [NgayMuon]=?, [NgayTra]=?, [MaThuThu]=?, [TinhTrang]=? WHERE [MaPM]=?";
    private static final String DELETE_SQL = "DELETE FROM [dbo].[PhieuMuon] WHERE [MaPM]=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[PhieuMuon]";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[PhieuMuon] WHERE [MaPM]=?";

    @Override
    public void insert(PhieuMuon phieuMuon) {
        JdbcHelper.update(INSERT_SQL,
                phieuMuon.getMaDG(),
                phieuMuon.getMaSach(),
                phieuMuon.getNgayMuon(),
                phieuMuon.getNgayTra(),
                phieuMuon.getMaThuThu(),
                phieuMuon.isTinhTrang());
    }

    @Override
    public void update(PhieuMuon phieuMuon) {
        JdbcHelper.update(UPDATE_SQL,
                phieuMuon.getMaDG(),
                phieuMuon.getMaSach(),
                phieuMuon.getNgayMuon(),
                phieuMuon.getNgayTra(),
                phieuMuon.getMaThuThu(),
                phieuMuon.isTinhTrang(),
                phieuMuon.getMaPM());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public PhieuMuon selectById(Integer id) {
        List<PhieuMuon> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<PhieuMuon> selectBySQL(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuMuon phieuMuon = new PhieuMuon();
                phieuMuon.setMaPM(rs.getInt("MaPM"));
                phieuMuon.setMaDG(rs.getString("MaDG"));
                phieuMuon.setMaSach(rs.getString("MaSach"));
                phieuMuon.setNgayMuon(rs.getDate("NgayMuon"));
                phieuMuon.setNgayTra(rs.getDate("NgayTra"));
                phieuMuon.setMaThuThu(rs.getString("MaThuThu"));
                phieuMuon.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(phieuMuon);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
