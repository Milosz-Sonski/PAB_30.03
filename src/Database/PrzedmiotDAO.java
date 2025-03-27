package Database;

import Models.Przedmiot;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PrzedmiotDAO {
    public List<Przedmiot> pobierzPrzedmioty() {
        List<Przedmiot> przedmioty = new ArrayList<>();
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement("SELECT * FROM przedmiot");
             ResultSet rezultat = skladnia.executeQuery()) {

            while (rezultat.next()) {
                przedmioty.add(new Przedmiot(
                        rezultat.getInt("id"),
                        rezultat.getString("nazwa"),                      
                        rezultat.getString("dzien"),
                        rezultat.getString("godzina"),
                        rezultat.getInt("sala"),
                        rezultat.getInt("prowadzacy_id")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        return przedmioty;
    }
    
     public void dodajPrzedmiot(String nazwa, String dzien, String godzina, int sala, int prowadzacy_id) {
        String sql = "INSERT INTO przedmiot (nazwa, dzien, godzina, sala, prowadzacy_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement(sql)) {

            skladnia.setString(1, nazwa);
            skladnia.setString(2, dzien);
            skladnia.setString(3, godzina);
            skladnia.setInt(4, sala);
            skladnia.setInt(5, prowadzacy_id);
            skladnia.executeUpdate();

            JOptionPane.showMessageDialog(null, "Przedmiot dodany!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd dodawania: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
     }
     
     public void usunPrzedmiot(int id) {
        String sql = "DELETE FROM przedmiot WHERE id = ?";
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement(sql)) {

            skladnia.setInt(1, id);
            int affectedRows = skladnia.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Przedmiot usunięty!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nie znaleziono przedmiotu!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd usuwania: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}