package wk1;

import java.time.LocalDate;

public class meteo {
    private String ville;
    private LocalDate date;
    private double mesure;

    public meteo() {}

    public meteo(String ville, LocalDate date, double mesure) {
        this.ville = ville;
        this.date = date;
        this.mesure = mesure;
    }

    public String getVille() {
        return ville;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMesure() {
        return mesure;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMesure(double mesure) {
        this.mesure = mesure;
    }
}
