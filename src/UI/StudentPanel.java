package UI;

import Database.StudentDAO;
import Models.Student;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel {
    private JTextArea textArea;
    private StudentDAO studentDAO;

    public StudentPanel() {
        setLayout(new BorderLayout());
        studentDAO = new StudentDAO();

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Dodaj Studenta");
        addButton.addActionListener(e -> {
            String imie = JOptionPane.showInputDialog("Podaj imię:");
            String nazwisko = JOptionPane.showInputDialog("Podaj nazwisko:");
            int przedmiot_id = Integer.parseInt(JOptionPane.showInputDialog("Podaj id przedmiotu:"));

            studentDAO.dodajStudenta(imie, nazwisko, przedmiot_id);
            odswiezListe();
        });

        JButton removeButton = new JButton("Usuń Studenta");
        removeButton.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Podaj ID studenta do usunięcia:"));
            studentDAO.usunStudenta(id);
            odswiezListe();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        odswiezListe();
    }

    private void odswiezListe() {
        textArea.setText("");
        List<Student> students = studentDAO.pobierzStudentow();
        for (Student student : students) {
            textArea.append(student.getId() + ": " + student.getImie() + " " + student.getNazwisko() + "\n");
        }
    }
}