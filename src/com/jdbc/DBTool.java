package com.jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;

//操作工具
public class DBTool {
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    //构造方法赋值
    public DBTool(Connection conn) {
        this.conn = conn;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //注册账号
    public void insert(String username, String password) throws SQLException {
        String sql = "INSERT INTO user(username,password,RegistrationDate) VALUES(?,?,?)";
        pstmt = conn.prepareCall(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setDate(3, getDate());
        pstmt.executeUpdate();
    }

    //获取当前系统时间（辅助注册账号）
    private java.sql.Date getDate() {
        java.util.Date date = new java.util.Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        return date1;
    }

    //查询账号是否存在
    public int selectUser(String username) throws SQLException {
        String sql = "select * from user where username = " + username;
        rs = stmt.executeQuery(sql);
        rs.last();
        int i = rs.getRow();
        return i;
    }

    //查询密码
    public String selectPassword(String username) throws SQLException {
        String sql = "select password from user where username = " + username;
        rs = stmt.executeQuery(sql);
        rs.next();
        String password = rs.getString("password");
        return password;
    }
}
