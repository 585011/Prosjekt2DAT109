package no.hvl.dat109.objekt;

public class Kunde {
    private String fornavn;
    private String etternavn;
    private Adresse adresse;
    private int tlfnr;
    private Kredittkort kredittkort;

    public Kunde(String fnavn, String enavn, Adresse adresse, int tlfnr) {
        this.fornavn = fnavn;
        this.etternavn = enavn;
        this.adresse = adresse;
        this.tlfnr = tlfnr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(int tlfnr) {
        this.tlfnr = tlfnr;
    }

    public void setKredittkort(Kredittkort k){
        this.kredittkort = k;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", adresse=" + adresse.toString() +
                ", tlfnr=" + tlfnr +
                '}' + "\n";
    }
}
