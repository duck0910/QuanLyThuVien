/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity_Class.DocGia;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VTOS
 */

public class DocGiaDAO extends LibSysDAO<DocGia, String> {

    String INSERT_SQL = "INSERT INTO [dbo].[DocGia]([MaDG], [TenDG], [DiaChi], [GioiTinh], [DienThoai])VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[DocGia] SET [TenDG]=?, [DiaChi]=?, [GioiTinh]=?, [DienThoai]=? WHERE [MaDG]=?";
    String DELETE_SQL = "DELETE FROM [dbo].[DocGia] WHERE [MaDG]=?";
    String SELECT_ALL_SQL = "SELECT * FROM [dbo].[DocGia]";
    String SELECT_BY_ID_SQL = "SELECT * FROM [dbo].[DocGia]  WHERE [MaDG]=?";

    @Override
    public void insert(DocGia docGia) {
        JdbcHelper.update(INSERT_SQL,
                docGia.getMaDG(),
                docGia.getTenDG(),
                docGia.getDiaChi(),
                docGia.isGioiTinh(),
                docGia.getDienThoai());
    }

    @Override
    public void update(DocGia docGia) {
        JdbcHelper.update(UPDATE_SQL,
                docGia.getTenDG(),
                docGia.getDiaChi(),
                docGia.isGioiTinh(),
                docGia.getDienThoai(),
                docGia.getMaDG());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public DocGia selectById(String id) {
        List<DocGia> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DocGia> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<DocGia> selectBySQL(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DocGia docGia = new DocGia();
                docGia.setMaDG(rs.getString("MaDG"));
                docGia.setTenDG(rs.getString("TenDG"));
                docGia.setDiaChi(rs.getString("DiaChi"));
                docGia.setGioiTinh(rs.getBoolean("GioiTinh"));
                docGia.setDienThoai(rs.getString("DienThoai"));
                list.add(docGia);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
