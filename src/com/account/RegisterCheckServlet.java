package com.account;

import java.sql.Connection;
import java.sql.SQLException;

import com.jdbc.*;

public class RegisterCheckServlet {
    public String returnResult(String username, String password) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        DBTool myDb = new DBTool(conn);
        String result = null;
        if ((myDb.selectUser(username)) == 0) {
            myDb.insert(username, password);
            result = "registered successfully";
        } else {
            result = "registration failed";
        }
        JDBCUtil.close(myDb.rs, myDb.stmt, myDb.pstmt, myDb.conn);
        return result;
    }
}
