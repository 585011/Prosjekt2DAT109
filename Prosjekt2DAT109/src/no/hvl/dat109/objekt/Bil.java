package no.hvl.dat109.objekt;

public class Bil {
    private String regnr;
    private String merke; //evt ha en merke klasse
    private String modell;
    private String farge;
    private Utleiergruppe utleiergruppe; //størrelse på bilen, kan evt ha enum her
    private int kmstand;
    private boolean ledig;

    public Bil(String regnr, String merke, String modell, String farge, Utleiergruppe utleiergruppe) {
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleiergruppe = utleiergruppe;
        this.ledig = true;
        this.kmstand = 0;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public Utleiergruppe getUtleiergruppe() {
        return utleiergruppe;
    }

    public void setUtleiergruppe(Utleiergruppe utleiergruppe) {
        this.utleiergruppe = utleiergruppe;
    }

    public int getKmstand() {
        return kmstand;
    }

    public void setKmstand(int kmstand) {
        this.kmstand = kmstand;
    }

    public boolean isLedig() {
        return ledig;
    }

    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }

    public int getPris(){
        int pris = 0;
        switch(utleiergruppe){
            case A:
                pris = 250;
                break;
            case B:
                pris = 350;
                break;
            case C:
                pris = 450;
                break;
            case D:
                pris = 600;
                break;
        }
        return pris;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "regnr='" + regnr + '\'' +
                ", merke='" + merke + '\'' +
                ", modell='" + modell + '\'' +
                ", farge='" + farge + '\'' +
                ", utleiergruppe=" + utleiergruppe +
                ", kmstand=" + kmstand +
                ", ledig=" + ledig +
                '}' + "\n";
    }
}
