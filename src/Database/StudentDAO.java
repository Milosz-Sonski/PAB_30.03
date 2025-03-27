package Database;

import Models.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentDAO {
    public List<Student> pobierzStudentow() {
        List<Student> studenci = new ArrayList<>();
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement("SELECT * FROM student");
             ResultSet rezultat = skladnia.executeQuery()) {

            while (rezultat.next()) {
                studenci.add(new Student(
                        rezultat.getInt("id"),
                        rezultat.getString("imie"),
                        rezultat.getString("nazwisko"),
                        rezultat.getInt("przedmiot_id")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        return studenci;
    }
    
    public void dodajStudenta(String imie, String nazwisko, int przedmiot_id) {
        String sql = "INSERT INTO student (imie, nazwisko, przedmiot_id) VALUES (?, ?, ?)";
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement(sql)) {
            
            skladnia.setString(1, imie);
            skladnia.setString(2, nazwisko);
            skladnia.setInt(3, przedmiot_id);
            skladnia.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student dodany!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd dodawania: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void usunStudenta(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection polaczenie = DatabaseConnection.getConnection();
             PreparedStatement skladnia = polaczenie.prepareStatement(sql)) {

            skladnia.setInt(1, id);
            int affectedRows = skladnia.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Student usunięty!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nie znaleziono studenta!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd usuwania: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}

