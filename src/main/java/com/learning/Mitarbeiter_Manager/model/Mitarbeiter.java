package com.learning.Mitarbeiter_Manager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nachname;
    String vorname;

    int gehalt;
    String stadt;

    public Mitarbeiter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getGehalt() {
        return gehalt;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }


    public Mitarbeiter(Long id, String vorname, String nachname, int gehalt, String stadt) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gehalt = gehalt;
        this.stadt = stadt;
    }


}
