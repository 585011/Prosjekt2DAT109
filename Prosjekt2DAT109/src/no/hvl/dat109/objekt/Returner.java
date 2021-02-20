package no.hvl.dat109.objekt;

import java.time.LocalDate;
import java.time.LocalTime;

public class Returner {
    private LocalDate returDato;
    private LocalTime returTid;
    private int kmStand;

    public Returner(LocalDate returDato, LocalTime returTid, int kmStand) {
        this.returDato = returDato;
        this.returTid = returTid;
        this.kmStand = kmStand;
    }

    public LocalDate getReturDato() {
        return returDato;
    }

    public void setReturDato(LocalDate returDato) {
        this.returDato = returDato;
    }

    public LocalTime getReturTid() {
        return returTid;
    }

    public void setReturTid(LocalTime returTid) {
        this.returTid = returTid;
    }

    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }

}
