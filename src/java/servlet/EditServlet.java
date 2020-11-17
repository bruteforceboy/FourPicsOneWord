package servlet;

import bean.Puzzle;
import db.PuzzleDB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.jdbc.pool.DataSource;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
@MultipartConfig
public class EditServlet extends HttpServlet {
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Puzzle selectedPuzzle = PuzzleDB.getPuzzle(getConnection(), id);
            request.setAttribute("selectedPuzzle", selectedPuzzle);
            RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            System.err.println("Error in EditServlet doGet: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Puzzle selectedPuzzle = PuzzleDB.getPuzzle(getConnection(), id);
            String image1, image2, image3, image4, answer;
            if (noFile(request.getPart("image1"))) {
                image1 = selectedPuzzle.getImage1();
            } else {
                image1 = process(request.getPart("image1"), request, response);
            }
            if (noFile(request.getPart("image2"))) {
                image2 = selectedPuzzle.getImage2();
            } else {
                image2 = process(request.getPart("image2"), request, response);
            }
            if (noFile(request.getPart("image3"))) {
                image3 = selectedPuzzle.getImage3();
            } else {
                image3 = process(request.getPart("image3"), request, response);
            }
            if (noFile(request.getPart("image4"))) {
                image4 = selectedPuzzle.getImage4();
            } else {
                image4 = process(request.getPart("image4"), request, response);
            }
            if (request.getParameter("answer").equals("")) {
                answer = selectedPuzzle.getAnswer();
            } else {
                answer = request.getParameter("answer").toLowerCase();
            }
            PuzzleDB.updatePuzzle(getConnection(), id, image1, image2, image3, image4, answer);
            response.sendRedirect("admin.jsp");
        } catch (SQLException ex) {
            System.err.println("Error in EditServlet doPost: " + ex.getMessage());
        }
    }
    
    private boolean noFile(Part filePart) {
        String fileName = getFileName(filePart);
       return "".equals(fileName);
    }
    
    private String process(Part filePart, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String photo = null;
        String path = "C:/Users/WILSON/Pictures/FourPicsOneWord";
        File file = new File(path);
        file.mkdir();
        String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        PrintWriter writer = response.getWriter();
        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                photo = fileName;

            }
        } catch (IOException ex) {
            System.err.println("Error in AddPuzzleServlet process: " + ex.getMessage());
        }
        return photo;
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    private Connection getConnection() throws SQLException {
        DataSource ds
                = (DataSource) getServletContext().getAttribute("DATA_SOURCE");
        Connection connection = ds.getConnection();
        return connection;
    }
}
