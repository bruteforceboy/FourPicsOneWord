package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoadImage", urlPatterns
        = {
            "/dbimages/*"
        })
public class LoadImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestedImage = request.getPathInfo();

        if (requestedImage != null) {
            final String IMAGES_FOLDER
                    = "C:/Users/WILSON/Pictures/FourPicsOneWord";
            requestedImage = URLDecoder.decode(requestedImage, "UTF-8");
            File imageFile = new File(IMAGES_FOLDER, requestedImage);

            if (imageFile.exists()) {
                String contentType = getServletContext().getMimeType(imageFile.getName());
                response.setContentType(contentType);
                response.setHeader("Content-Length",
                        String.valueOf(imageFile.length()));

                Files.copy(imageFile.toPath(),
                        response.getOutputStream());
            } else {
                response.sendError(404);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}