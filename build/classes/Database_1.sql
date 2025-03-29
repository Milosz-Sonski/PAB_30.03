CREATE DATABASE uczelnia;
USE uczelnia;


CREATE TABLE student (
    id INT IDENTITY(1,1) PRIMARY KEY,
    imie VARCHAR(50) NOT NULL,
    nazwisko VARCHAR(50) NOT NULL,
    przedmiot_id INT,
);

CREATE TABLE prowadzacy (
    id INT IDENTITY(1,1) PRIMARY KEY,
    imie VARCHAR(50) NOT NULL,
    nazwisko VARCHAR(50) NOT NULL
);

CREATE TABLE przedmiot (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nazwa VARCHAR(100),
    dzien VARCHAR(20),
    godzina VARCHAR(10),
    sala INT,
    prowadzacy_id INT,
    FOREIGN KEY (prowadzacy_id) REFERENCES prowadzacy(id)
);


INSERT INTO prowadzacy (imie, nazwisko) VALUES ('Jan', 'Kowalski');
INSERT INTO przedmiot (nazwa, dzien, godzina, sala, prowadzacy_id) VALUES ('Matematyka', 'Poniedziałek', '08:00', 101, 1);
INSERT INTO student (imie, nazwisko, przedmiot_id) VALUES ('Anna', 'Nowak', 1);

SELECT * FROM student
SELECT * FROM przedmiot
SELECT * FROM prowadzacy