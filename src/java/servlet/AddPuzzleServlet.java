package servlet;

import db.PuzzleDB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.jdbc.pool.DataSource;

@WebServlet(name = "AddPuzzleServlet", urlPatterns = {"/add-puzzle"})
@MultipartConfig
public class AddPuzzleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String photo1 = process(request.getPart("image1"), request, response);
        String photo2 = process(request.getPart("image2"), request, response);
        String photo3 = process(request.getPart("image3"), request, response);
        String photo4 = process(request.getPart("image4"), request, response);
        String answer = request.getParameter("answer");
        answer = answer.toLowerCase();
        
        boolean success = false;
        
        try {
            success = PuzzleDB.addPuzzle(getConnection(), photo1, photo2, photo3, photo4, answer);
        } catch (SQLException ex) {
            System.err.println("Error occured in AddPuzzleServlet doPost: " + ex.getMessage());
        }
        
        HttpSession session = request.getSession();
        if (!success) {
            session.setAttribute("notInserted", true);
        } else {
            session.setAttribute("notInserted", false);
        }
        response.sendRedirect("admin.jsp");
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
