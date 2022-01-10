package demo.entities;

import java.util.Objects;

public class Offerte {
    private Integer id;
    private String unternehmensname;
    private float preis;
    private float mehrwertsteuer;
    private String adresse;
    private Ort ort;

    public Offerte() {
    }

    public Offerte(Integer id, String unternehmensname, float preis, float mehrwertsteuer, String adresse, Ort ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.preis = preis;
        this.mehrwertsteuer = mehrwertsteuer;
        this.adresse = adresse;
        this.ort = ort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public float getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    public void setMehrwertsteuer(float mehrwertsteuer) {
        this.mehrwertsteuer = mehrwertsteuer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Offerte{" +
                "id=" + id +
                ", unternehmensname='" + unternehmensname + '\'' +
                ", preis=" + preis +
                ", mehrwertsteuer=" + mehrwertsteuer +
                ", adresse='" + adresse + '\'' +
                ", ort=" + ort +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offerte offerte = (Offerte) o;
        return id.equals(offerte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
