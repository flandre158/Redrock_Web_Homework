package com.account;

import com.jdbc.DBTool;
import com.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginCheckServlet {
    public String returnResult(String username, String password) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        DBTool myDb = new DBTool(conn);
        String result = null;
        if ((myDb.selectUser(username)) == 0) {
            result = "The corresponding user could not be found";
        } else {
            if ((myDb.selectPassword(username)).equals(password) == true) {
                result = "Password correct, login successful";
            } else {
                result = "Wrong password, please try again";
            }
        }
        JDBCUtil.close(myDb.rs, myDb.stmt, myDb.pstmt, myDb.conn);
        return result;
    }
}
