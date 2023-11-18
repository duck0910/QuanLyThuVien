package DAO;

import Entity_Class.TheLoai;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO extends LibSysDAO<TheLoai, String> {

    String INSERT_SQL = "INSERT INTO [dbo].[TheLoai]([MaTL],[TenTL])VALUES(?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[TheLoai] SET [TenTL]=? WHERE [MaTL]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[TheLoai] WHERE [MaTL]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[TheLoai]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[TheLoai]  WHERE [MaTL]=?";

    @Override
    public void insert(TheLoai theLoai) {
        JdbcHelper.update(INSERT_SQL,
                theLoai.getMaTL(),
                theLoai.getTenTL());
    }

    @Override
    public void update(TheLoai theLoai) {
        JdbcHelper.update(UPDATE_SQL,
                theLoai.getTenTL(),
                theLoai.getMaTL());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public TheLoai selectById(String id) {
        List<TheLoai> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TheLoai> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<TheLoai> selectBySQL(String sql, Object... args) {
        List<TheLoai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setMaTL(rs.getString("MaTL"));
                theLoai.setTenTL(rs.getString("TenTL"));
                list.add(theLoai);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
