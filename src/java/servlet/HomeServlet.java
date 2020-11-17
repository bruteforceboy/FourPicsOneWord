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

@WebServlet(name = "HomeServlet", urlPatterns = {"/index.jsp"})
public class HomeServlet extends HttpServlet {

    private List<Puzzle> puzzleList = null;
    private int id = -1;
    private int score = 0;
    private boolean incorrect = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!incorrect) {
            try {
                puzzleList = PuzzleDB.getPuzzles(getConnection());
            } catch (SQLException ex) {
                System.err.println("Error in HomeServlet doGet: " + ex.getMessage());
            }
            int length = puzzleList.size();
            if (length > 0) {
                id = (id + 1) % length;
            } else {
                id = -1;
            }
            request.setAttribute("score", score);
            if (puzzleList.size() > 0) {
                request.setAttribute("currentPuzzle", puzzleList.get(id));
            }
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("incorrect", true);
            request.setAttribute("score", score);
            if (puzzleList.size() > 0) {
                request.setAttribute("currentPuzzle", puzzleList.get(id));
            }
            incorrect = false;
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = (String) request.getParameter("user-answer");
        answer = answer.toLowerCase();
        if (id != -1 && answer.equals(puzzleList.get(id).getAnswer())) {
            int wordLength = puzzleList.get(id).getAnswer().length();
            score = score + (10 * wordLength);
        } else {
            incorrect = true;
        }
        doGet(request, response);
    }

    private Connection getConnection() throws SQLException {
        DataSource ds
                = (DataSource) getServletContext().getAttribute("DATA_SOURCE");
        Connection connection = ds.getConnection();
        return connection;
    }
}
