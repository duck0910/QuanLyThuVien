package DAO;

import Entity_Class.TacGia;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TacGiaDAO extends LibSysDAO<TacGia, String> {
String INSERT_SQL = "INSERT INTO [dbo].[TacGia]([MaTG], [TenTG], [GioiTinh], [NgaySinh], [Email]) VALUES(?,?,?,?,?)";
  String UPDATE_SQL = "UPDATE [dbo].[TacGia] SET [TenTG]=?, [GioiTinh]=?, [NgaySinh]=?, [Email]=? WHERE [MaTG]=?";
  String DELETE_SQL = "DELETE FROM [dbo].[TacGia] WHERE [MaTG]=?";
  String SELECT_ALL_SQL = "SELECT * FROM [dbo].[TacGia]";
  String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[TacGia] WHERE [MaTG]=?";

  @Override
  public void insert(TacGia tacGia) {
    JdbcHelper.update(INSERT_SQL,
        tacGia.getMaTG(),
        tacGia.getTenTG(),
        tacGia.isGioiTinh(),
        tacGia.getNgaySinh(),
        tacGia.getEmail());
  }

  @Override
  public void update(TacGia tacGia) {
    JdbcHelper.update(UPDATE_SQL,
        tacGia.getTenTG(),
        tacGia.isGioiTinh(),
        tacGia.getNgaySinh(),
        tacGia.getEmail(),
        tacGia.getMaTG());
  }

  @Override
  public void delete(String id) {
    JdbcHelper.update(DELETE_SQL, id);
  }

  @Override
  public TacGia selectById(String id) {
    List<TacGia> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public List<TacGia> selectAll() {
    return this.selectBySQL(SELECT_ALL_SQL);
  }

  @Override
  protected List<TacGia> selectBySQL(String sql, Object... args) {
    List<TacGia> list = new ArrayList<>();
    try {
      ResultSet rs = JdbcHelper.query(sql, args);
      while (rs.next()) {
        TacGia tacGia = new TacGia();
        tacGia.setMaTG(rs.getString("MaTG"));
        tacGia.setTenTG(rs.getString("TenTG"));
        tacGia.setGioiTinh(rs.getBoolean("GioiTinh"));
        tacGia.setNgaySinh(rs.getDate("NgaySinh"));
        tacGia.setEmail(rs.getString("Email"));
        list.add(tacGia);
      }
      rs.getStatement().getConnection().close();
      return list;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
