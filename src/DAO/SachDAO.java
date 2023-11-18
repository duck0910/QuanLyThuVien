package DAO;

import Entity_Class.Sach;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachDAO extends LibSysDAO<Sach, String> {

    String INSERT_SQL = "INSERT INTO [dbo].[sach]([MaSach], [TenSach], [MaNXB], [MaTL], [SoLuong], [NgayNhap], [ViTri], [Hinh])VALUES(?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[sach] SET [TenSach]=?, [MaNXB]=?, [MaTL]=?, [SoLuong]=?, [NgayNhap]=?, [ViTri]=?, [Hinh]=? WHERE [MaSach]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[sach] WHERE [MaSach]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[sach]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[sach]  WHERE [MaSach]=?";

    @Override
    public void insert(Sach sach) {
        JdbcHelper.update(INSERT_SQL,
                sach.getMaSach(),
                sach.getTenSach(),
                sach.getMaNXB(),
                sach.getMaTL(),
                sach.getSoLuong(),
                sach.getNgayNhap(),
                sach.getViTri(),
                sach.getHinh());
    }

    @Override
    public void update(Sach sach) {
        JdbcHelper.update(UPDATE_SQL,
                sach.getTenSach(),
                sach.getMaNXB(),
                sach.getMaTL(),
                sach.getSoLuong(),
                sach.getNgayNhap(),
                sach.getViTri(),
                sach.getHinh(),
                sach.getMaSach());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<Sach> selectBySQL(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setMaNXB(rs.getString("MaNXB"));
                sach.setMaTL(rs.getString("MaTL"));
                sach.setSoLuong(rs.getInt("SoLuong"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                sach.setViTri(rs.getString("ViTri"));
                sach.setHinh(rs.getString("Hinh"));
                list.add(sach);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
