package Models;

public class Student {
    private int id;
    private String imie;
    private String nazwisko;
    private int przedmiotId;

    public Student(int id, String imie, String nazwisko, int przedmiotId) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.przedmiotId = przedmiotId;
    }

    public int getId() { return id; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public int getPrzedmiotId() { return przedmiotId; }
}