package DAO;

import Entity_Class.SachTheoTacGia;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachTheoTacGiaDAO extends LibSysDAO<SachTheoTacGia, String> {

    String INSERT_SQL = "INSERT INTO [dbo].[SachTheoTacGia]([MaSach],[MaTG])VALUES(?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[SachTheoTacGia] SET [MaSach]=? WHERE [MaTG]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[SachTheoTacGia] WHERE [MaTG]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[SachTheoTacGia]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[SachTheoTacGia]  WHERE [MaTG]=?";

    @Override
    public void insert(SachTheoTacGia sachTheoTacGia) {
        JdbcHelper.update(INSERT_SQL,
                sachTheoTacGia.getMaSach(),
                sachTheoTacGia.getMaTG());
    }

    @Override
    public void update(SachTheoTacGia sachTheoTacGia) {
        JdbcHelper.update(UPDATE_SQL,
                sachTheoTacGia.getMaSach(),
                sachTheoTacGia.getMaTG());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public SachTheoTacGia selectById(String id) {
        List<SachTheoTacGia> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SachTheoTacGia> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<SachTheoTacGia> selectBySQL(String sql, Object... args) {
        List<SachTheoTacGia> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SachTheoTacGia sachTheoTacGia = new SachTheoTacGia();
                sachTheoTacGia.setMaSach(rs.getString("MaSach"));
                sachTheoTacGia.setMaTG(rs.getString("MaTG"));
                list.add(sachTheoTacGia);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
