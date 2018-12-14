package com.account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {
        LoginCheckServlet loginCheckServlet = new LoginCheckServlet();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            response.getWriter().write(loginCheckServlet.returnResult(username, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
