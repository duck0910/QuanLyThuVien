package DAO;

import Entity_Class.ThuThu;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThuThuDAO extends LibSysDAO<ThuThu, String> {

    String INSERT_SQL = "INSERT INTO [dbo].ThuThuVALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[ThuThu] SET [TenThuThu]=?,[MatKhau]=?,[VaiTro]=? WHERE [MaThuThu]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[ThuThu] WHERE [MaThuThu]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[ThuThu]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[ThuThu]  WHERE [MaThuThu]=?";

    @Override
    public void insert(ThuThu thuThu) {
        JdbcHelper.update(INSERT_SQL,
                thuThu.getMaThuThu(),
                thuThu.getTenThuThu(),
                thuThu.getMatKhau(),
                thuThu.isVaiTro());
    }

    @Override
    public void update(ThuThu thuThu) {
        JdbcHelper.update(UPDATE_SQL,
                thuThu.getTenThuThu(),
                thuThu.getMatKhau(),
                thuThu.isVaiTro(),
                thuThu.getMaThuThu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public ThuThu selectById(String id) {
        List<ThuThu> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThuThu> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<ThuThu> selectBySQL(String sql, Object... args) {
        List<ThuThu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ThuThu thuThu = new ThuThu();
                thuThu.setMaThuThu(rs.getString("MaThuThu"));
                thuThu.setTenThuThu(rs.getString("TenThuThu"));
                thuThu.setMatKhau(rs.getString("MatKhau"));
                thuThu.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(thuThu);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
