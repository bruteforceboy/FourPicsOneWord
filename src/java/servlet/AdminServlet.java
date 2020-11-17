package servlet;

import bean.Puzzle;
import db.PuzzleDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin.jsp"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Puzzle> puzzleList = PuzzleDB.getPuzzles(getConnection());
            request.setAttribute("puzzleList", puzzleList);
            RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            System.err.println("Error in AdminServlet doGet " + ex.getMessage());
        }
    }
    
    private Connection getConnection() throws SQLException {
        DataSource ds
                = (DataSource) getServletContext().getAttribute("DATA_SOURCE");
        Connection connection = ds.getConnection();
        return connection;
    }
}
