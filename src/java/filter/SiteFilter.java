package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns
        = {
            "/*"
        })
public class SiteFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        if (httpRequest.getRequestURI().endsWith("index.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("home.jsp")) {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else if (httpRequest.getRequestURI().endsWith("admin.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("admin-dashboard.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("add-puzzle.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("edit.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("edit")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (httpRequest.getRequestURI().endsWith("login.jsp")) {
            boolean isLoggedIn = (session != null && session.getAttribute("adminLoggedIn") != null);
            if (isLoggedIn) {
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }
}
