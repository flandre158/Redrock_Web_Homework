package com.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {
        RegisterCheckServlet registerCheckServlet = new RegisterCheckServlet();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            response.getWriter().write(registerCheckServlet.returnResult(username, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
