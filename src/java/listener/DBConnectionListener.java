package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.tomcat.jdbc.pool.DataSource;

public class DBConnectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String DB_URL = "jdbc:mysql://localhost:3306/fourpicsoneword_db"
                + "?serverTimezone=Africa/Lagos";
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "admin";

        final DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        ds.setInitialSize(10);
        ds.setMaxActive(100);
        ds.setMinEvictableIdleTimeMillis(30000);
        ds.setTestOnBorrow(true);
        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(60);
        ds.setValidationInterval(30000);
        ds.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        sce.getServletContext().setAttribute("DATA_SOURCE", ds);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataSource ds = (DataSource) sce.getServletContext().getAttribute("DATA_SOURCE");
        ds.close();
    }
}
