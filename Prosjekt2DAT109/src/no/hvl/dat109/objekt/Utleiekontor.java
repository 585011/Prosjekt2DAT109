package no.hvl.dat109.objekt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Utleiekontor {
    private Bilutleieselskap bulSelskap;
    private final AtomicInteger kontornrteller = new AtomicInteger();
    private int kontornr;
    private Adresse adresse;
    private int tlfnr;
    private List<Bil> bilListe;

    public Utleiekontor(Bilutleieselskap buls,Adresse adresse, int tlfnr) {
        this.bulSelskap = buls;
        this.adresse = adresse;
        this.tlfnr = tlfnr;
        this.kontornr = kontornrteller.incrementAndGet();
        this.bilListe = new ArrayList<Bil>();
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adr){
        this.adresse = adr;
    }

    public int getKontornr() {
        return kontornr;
    }

    public int getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(int tlfnr) {
        this.tlfnr = tlfnr;
    }

    public List<Bil> getBilListe(){
        return this.bilListe;
    }

    public void setBilListe(List<Bil> bilListe){
        this.bilListe = bilListe;
    }

    public void leggTilBil(Bil bil){
        this.bilListe.add(bil);
    }
    public void setBulSelskap(Bilutleieselskap b){
        this.bulSelskap = b;
    }

    /**
     * Laga en reservasjon til en bil, i reserver klassen blir då bilen setLedig(false)
     * @param bil
     * @param utK
     * @param retK
     * @param kun
     * @param stDat
     * @param stT
     * @param antDag
     * @return en reservasjon av bil.
     */
    public Reserver reservereBil(Bil bil, Utleiekontor utK, Utleiekontor retK, Kunde kun,
                                 LocalDate stDat, LocalTime stT, int antDag){

        //  public Reserver(Kunde kunde, Bil bil, Utleiekontor utleieSted, Utleiekontor returSted,
        //                    LocalDate onsketDato, LocalTime onsketKlSlett, int antDag) {
        Reserver reserver = new Reserver(kun, bil, utK, retK, stDat, stT, antDag);

        return reserver;
    }

}
