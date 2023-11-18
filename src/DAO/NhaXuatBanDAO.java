package DAO;

import Entity_Class.NhaXuatBan;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaXuatBanDAO extends LibSysDAO<NhaXuatBan, String> {

    String INSERT_SQL = "INSERT INTO [dbo].[NhaXuatBan]([MaNXB],[TenNXB])VALUES(?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[NhaXuatBan] SET [TenNXB]=? WHERE [MaNXB]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[NhaXuatBan] WHERE [MaNXB]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[NhaXuatBan]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[NhaXuatBan]  WHERE [MaNXB]=?";

    @Override
    public void insert(NhaXuatBan nhaXuatBan) {
        JdbcHelper.update(INSERT_SQL, nhaXuatBan.getMaNXB(), nhaXuatBan.getTenNXB());
    }

    @Override
    public void update(NhaXuatBan nhaXuatBan) {
        JdbcHelper.update(UPDATE_SQL, nhaXuatBan.getTenNXB(), nhaXuatBan.getMaNXB());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public NhaXuatBan selectById(String id) {
        List<NhaXuatBan> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaXuatBan> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhaXuatBan> selectBySQL(String sql, Object... args) {
        List<NhaXuatBan> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaXuatBan nhaXuatBan = new NhaXuatBan();
                nhaXuatBan.setMaNXB(rs.getString("MaNXB"));
                nhaXuatBan.setTenNXB(rs.getString("TenNXB"));
                list.add(nhaXuatBan);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
