package db;

import bean.Puzzle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuzzleDB {

    public static ArrayList<Puzzle> getPuzzles(Connection connection) {
        final String QUERY = "SELECT * FROM Puzzle";

        ArrayList<Puzzle> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new Puzzle(rs.getInt("id"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"), rs.getString("image4"),
                            rs.getString("answer")));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error occured in PuzzleDB getPuzzles: " + ex.getMessage());
        }

        return result;
    }

    public static void deletePuzzle(Connection connection, int id) {
        final String QUERY = "DELETE FROM Puzzle WHERE ID = ?";

        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error occured in PuzzleDB deletePuzzle: " + ex.getMessage());
        }
    }

    public static boolean addPuzzle(Connection connection, String image1, String image2, String image3, String image4, String answer) {
        final String QUERY = "INSERT INTO Puzzle(Image1, Image2, Image3, Image4, Answer)  VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {
            ps.setString(1, image1);
            ps.setString(2, image2);
            ps.setString(3, image3);
            ps.setString(4, image4);
            ps.setString(5, answer);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Error occured in PuzzleDB addPuzzle: " + ex.getMessage());
        }
        return false;
    }

    public static Puzzle getPuzzle(Connection connection, int id) {
        final String QUERY = "SELECT * FROM Puzzle WHERE ID = ?";

        Puzzle puzzle = new Puzzle();

        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    puzzle = new Puzzle(rs.getInt("id"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"), rs.getString("image4"),
                            rs.getString("answer"));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error occured in Puzzle DB getPuzzle: " + ex.getMessage());
        }

        return puzzle;
    }

    public static void updatePuzzle(Connection connection, int id, String image1, String image2, String image3, String image4, String answer) {
        final String QUERY = "UPDATE Puzzle SET image1 = ?, image2 = ?, image3 = ?, image4 = ?, answer = ? WHERE ID = ?";

        try (PreparedStatement ps = connection.prepareStatement(QUERY)) {
            ps.setString(1, image1);
            ps.setString(2, image2);
            ps.setString(3, image3);
            ps.setString(4, image4);
            ps.setString(5, answer);
            ps.setInt(6, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error occured in PuzzleDB updatePuzzle: " + ex.getMessage());
        }
    }
}
