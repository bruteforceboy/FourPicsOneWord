package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <title>FourPicsOneWord</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"nav-container\">\n");
      out.write("                <nav>\n");
      out.write("                    <!--                    <div class =\"logo-div\">\n");
      out.write("                        <span> CVGenerator </span>\n");
      out.write("                        </div>-->\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index.jsp\"> HOME </a></li>\n");
      out.write("                        <li><a href=\"login.jsp\"> LOGIN </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <main>\n");
      out.write("            <button class=\"btn\" id=\"myBtn\"><i class=\"fa fa-question\"></i>HELP</button>\n");
      out.write("            <div id=\"myModal\" class=\"modal\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <span class=\"close\">&times;</span>\n");
      out.write("                        <h2>Four Pics One Word</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>4 Pics 1 Word's gameplay is very simple: each level displays four pictures linked by one word - \n");
      out.write("                            the player's aim is to work out what the word is, from a set of letters given below the pictures.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <span style=\"float:right; color: white;\">\n");
      out.write("                <h2> SCORE: 0 </h2>\n");
      out.write("            </span>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"images/9da58a9f3d3e52ce862fadf4501f812e.jpg\" width=\"250px\" height=\"250px\" style=\"border-radius: 20px\"/></td>\n");
      out.write("                    <td><img src=\"images/9da58a9f3d3e52ce862fadf4501f812e.jpg\" width=\"250px\" height=\"250px\" style=\"border-radius: 20px\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"images/9da58a9f3d3e52ce862fadf4501f812e.jpg\" width=\"250px\" height=\"250px\" style=\"border-radius: 20px\"/></td>\n");
      out.write("                    <td><img src=\"images/9da58a9f3d3e52ce862fadf4501f812e.jpg\" widht=\"250px\" height=\"250px\" style=\"border-radius: 20px\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"text\">\n");
      out.write("            <center>\n");
      out.write("                <button class=\"btn\">SKIP</button>\n");
      out.write("                <button type=\"submit\" class=\"btn\"><i class=\"fa fa-play\"></i>PLAY</button>\n");
      out.write("            </center>\n");
      out.write("        </main>\n");
      out.write("        <br/>\n");
      out.write("        <footer class=\"site-footer\">\n");
      out.write("            <div class=\"social-wrapper\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/twitter-128.png\" alt=\"Twitter Logo\" class=\"twitter-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/instagram-icon.png\" alt=\"Instagram Logo\" class=\"instagram-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/facebook.ico\" alt=\"Facebook Logo\" class=\"facebook-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/Google-plus-icon.png\" alt=\"Googleplus Logo\" class=\"googleplus-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/youtube.png\" alt=\"Youtube Logo\" class=\"youtube-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" target=\"_blank\">\n");
      out.write("                        <img src=\"./images/Foursquare-2.ico\" alt=\"Foursquare Logo\" class=\"foursquare-icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"footer-nav\" role=\"navigation\">\n");
      out.write("                <p>Copyright &copy; 2020-2021 FourPicsOneWord. All rights reserved.</p>\n");
      out.write("            </nav>\n");
      out.write("        </footer>\n");
      out.write("        <script>\n");
      out.write("            var modal = document.getElementById(\"myModal\");\n");
      out.write("            var btn = document.getElementById(\"myBtn\");\n");
      out.write("            var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("            btn.onclick = function () {\n");
      out.write("                modal.style.display = \"block\";\n");
      out.write("            }\n");
      out.write("            span.onclick = function () {\n");
      out.write("                modal.style.display = \"none\";\n");
      out.write("            }\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == modal) {\n");
      out.write("                    modal.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
