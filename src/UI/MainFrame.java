package UI;

import Database.StudentDAO;
import Database.PrzedmiotDAO;
import Models.Student;
import Models.Przedmiot;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("System Uczelniany");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Studenci", new StudentPanel());
        tabbedPane.add("Przedmioty", new PrzedmiotPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }
}