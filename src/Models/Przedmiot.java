package Models;

public class Przedmiot {
    private int id;
    private String nazwa;
    private String dzien;
    private String godzina;
    private int sala;
    private int prowadzacyId;


    public Przedmiot(int id, String nazwa, String dzien, String godzina, int sala, int prowadzacyId) {
        this.id = id;
        this.nazwa = nazwa;
        this.dzien = dzien;
        this.godzina = godzina;
        this.sala = sala;
        this.prowadzacyId = prowadzacyId;
    }

    public int getId() { return id; }
    public String getNazwa() { return nazwa; }
    public String getDzien() { return dzien; }
    public String getGodzina() { return godzina; }
    public int getSala() { return sala; }
    public int getProwadzacyId() { return prowadzacyId; }
}
