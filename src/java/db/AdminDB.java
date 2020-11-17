package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDB {
    
    public static boolean isValid(Connection connection, String username, String password) {
        final String QUERY = "SELECT * FROM ADMIN WHERE username = ? AND password = MD5(?)";
        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error occured in AdminDB isValid: " + ex.getMessage());
        } 
        return false;
    }
}
