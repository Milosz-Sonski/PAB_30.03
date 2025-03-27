package UI;

import Database.PrzedmiotDAO;
import Models.Przedmiot;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrzedmiotPanel extends JPanel {
    private JTextArea textArea;
    private PrzedmiotDAO przedmiotDAO;

    public PrzedmiotPanel() {
        setLayout(new BorderLayout());
        przedmiotDAO = new PrzedmiotDAO();

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Dodaj Przedmiot");
        addButton.addActionListener(e -> {
            String nazwa = JOptionPane.showInputDialog("Podaj nazwę przedmiotu:");
            String dzien = JOptionPane.showInputDialog("Podaj dzień zajęć:");
            String godzina = JOptionPane.showInputDialog("Podaj godzinę zajęć:");
            int sala = Integer.parseInt(JOptionPane.showInputDialog("Podaj numer sali:"));
            int prowadzacy_id = Integer.parseInt(JOptionPane.showInputDialog("Podaj id prowadzącego:"));

            przedmiotDAO.dodajPrzedmiot(nazwa, dzien, godzina, sala, prowadzacy_id);
            odswiezListe();
        });

        JButton removeButton = new JButton("Usuń Przedmiot");
        removeButton.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Podaj ID przedmiotu do usunięcia:"));
            przedmiotDAO.usunPrzedmiot(id);
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
        List<Przedmiot> przedmioty = przedmiotDAO.pobierzPrzedmioty();
        for (Przedmiot przedmiot : przedmioty) {
            textArea.append(przedmiot.getId() + ": " + przedmiot.getNazwa() + ", " +
                    przedmiot.getProwadzacyId() + ", " +
                    przedmiot.getDzien() + ", " +
                    przedmiot.getGodzina() + ", " +
                    przedmiot.getSala() + "\n");
        }
    }
}