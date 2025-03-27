package Database;

import Models.Prowadzacy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProwadzacyDAO {
    public List<Prowadzacy> getAllProwadzacy() throws ClassNotFoundException {
        List<Prowadzacy> prowadzacy = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM prowadzacy")) {

            while (rs.next()) {
                prowadzacy.add(new Prowadzacy(rs.getInt("id"),
                                         rs.getString("imie"),
                                         rs.getString("nazwisko")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prowadzacy;
    }
    
}
