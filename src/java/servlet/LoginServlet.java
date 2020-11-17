package servlet;

import db.AdminDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jdbc.pool.DataSource;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            if (AdminDB.isValid(getConnection(), username, password)) {
                session.setAttribute("adminLoggedIn", true);
                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("loginError", true);
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
            System.err.println("Error occured in LoginServlet doPost: " + ex.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        DataSource ds
                = (DataSource) getServletContext().getAttribute("DATA_SOURCE");
        Connection connection = ds.getConnection();
        return connection;
    }
}
