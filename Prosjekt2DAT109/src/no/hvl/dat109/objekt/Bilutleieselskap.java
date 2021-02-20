package no.hvl.dat109.objekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bilutleieselskap {
    private String navn;
    private int tlfnr;
    private Adresse firmaAdresse;
    private List<Utleiekontor> utleiekontorList;
    //private HashMap<Integer, Utleiekontor> utleiekontorer;
    private List<Reserver> reservasjonsListe;
    private HashMap<Integer, Reserver> reservasjoner;
    private HashMap<Integer, Utleie> utleinger;
    private HashMap<Integer, Returner> retur;


    public Bilutleieselskap(String navn, int tlfnr, Adresse firmaAdresse) {
        this.navn = navn;
        this.tlfnr = tlfnr;
        this.firmaAdresse = firmaAdresse;
        this.utleiekontorList = new ArrayList<Utleiekontor>();
        this.reservasjonsListe = new ArrayList<Reserver>();
        this.reservasjoner = new HashMap<Integer, Reserver>();
        //this.utleiekontorer = new HashMap<Integer,Utleiekontor>();
        this.utleinger = new HashMap<Integer, Utleie>();
        this.retur = new HashMap<Integer, Returner>();

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(int tlfnr) {
        this.tlfnr = tlfnr;
    }

    public Adresse getFirmaAdresse() {
        return firmaAdresse;
    }

    public void setFirmaAdresse(Adresse firmaAdresse) {
        this.firmaAdresse = firmaAdresse;
    }

    public List<Utleiekontor> getUtleiekontorList() {
        return utleiekontorList;
    }

//   public HashMap<Integer,Utleiekontor> getUtleiekontorer(){
//        return utleiekontorer;
//    }

    public void nyReservasjon(Reserver res) {
        reservasjonsListe.add(res);

    }

    public void leggTilReservasjon(int tlfnr, Reserver res){
        reservasjoner.put(tlfnr,res);
    }

    public Reserver getReservasjon(int tlfnr){
        return reservasjoner.get(tlfnr);
    }

    public void leggTilUtleie(int tlfnr, Utleie utleie) {
        utleinger.put(tlfnr, utleie);
    }

    public void leggTilUtleiekontor(Utleiekontor utleiekontor) {
        utleiekontorList.add(utleiekontor);
    }

    public HashMap<Integer, Returner> getReturneringer(){
        return retur;
    }

    public void leggTilRetur(int tlfnr,Returner returner){
        retur.put(tlfnr, returner);
    }

    public Utleie getUtleie(int tlfnr){
        return utleinger.get(tlfnr);
    }
}
