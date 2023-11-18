package DAO;

import Entity_Class.PhieuMuonChiTiet;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonChiTietDAO extends LibSysDAO<PhieuMuonChiTiet, Integer> {

    private static final String INSERT_SQL = "INSERT INTO [dbo].[PhieuMuonChiTiet]([MaPM],[MaSach])VALUES(?,?)";
    private static final String UPDATE_SQL = "UPDATE [dbo].[PhieuMuonChiTiet] SET [MaPM]=?, [MaSach]=? WHERE [MaCTPM]=?";
    private static final String DELETE_SQL = "DELETE FROM [dbo].[PhieuMuonChiTiet] WHERE [MaCTPM]=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[PhieuMuonChiTiet]";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[PhieuMuonChiTiet] WHERE [MaCTPM]=?";

    @Override
    public void insert(PhieuMuonChiTiet phieuMuonChiTiet) {
        JdbcHelper.update(INSERT_SQL,
                phieuMuonChiTiet.getMaPM(),
                phieuMuonChiTiet.getMaSach());
    }

    @Override
    public void update(PhieuMuonChiTiet phieuMuonChiTiet) {
        JdbcHelper.update(UPDATE_SQL,
                phieuMuonChiTiet.getMaPM(),
                phieuMuonChiTiet.getMaSach(),
                phieuMuonChiTiet.getMaCTPM());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public PhieuMuonChiTiet selectById(Integer id) {
        List<PhieuMuonChiTiet> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PhieuMuonChiTiet> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<PhieuMuonChiTiet> selectBySQL(String sql, Object... args) {
        List<PhieuMuonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuMuonChiTiet phieuMuonChiTiet = new PhieuMuonChiTiet();
                phieuMuonChiTiet.setMaCTPM(rs.getInt("MaCTPM"));
                phieuMuonChiTiet.setMaPM(rs.getInt("MaPM"));
                phieuMuonChiTiet.setMaSach(rs.getString("MaSach"));
                list.add(phieuMuonChiTiet);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

