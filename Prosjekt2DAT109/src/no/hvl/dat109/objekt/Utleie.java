package no.hvl.dat109.objekt;

import java.time.LocalDate;
import java.time.LocalTime;

public class Utleie {
    private Kredittkort kk;
    private Bil bil;
    private LocalDate utleieDato;
    private LocalDate returnerDato;
    private LocalTime returKl;

    public Utleie(Kredittkort kk, Bil bil, LocalDate utleieDato, LocalDate returnerDato, LocalTime kl) {
        this.kk = kk;
        this.bil = bil;
        this.utleieDato = utleieDato;
        this.returnerDato = returnerDato;
        this.returKl = kl;
    }

    public Kredittkort getKk() {
        return kk;
    }

    public void setKk(Kredittkort kk) {
        this.kk = kk;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public LocalDate getUtleieDato() {
        return utleieDato;
    }

    public void setUtleieDato(LocalDate utleieDato) {
        this.utleieDato = utleieDato;
    }

    public LocalDate getReturnerDato() {
        return returnerDato;
    }

    public void setReturnerDato(LocalDate returnerDato) {
        this.returnerDato = returnerDato;
    }

    public LocalTime getReturKl() {
        return returKl;
    }

    public void setReturKl(LocalTime returKl) {
        this.returKl = returKl;
    }

    @Override
    public String toString() {
        return "Utleie{" +
                "kk=" + kk +
                ", bil=" + bil +
                ", utleieDato=" + utleieDato +
                ", returnerDato=" + returnerDato +
                '}';
    }
}
