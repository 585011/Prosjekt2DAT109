package no.hvl.dat109.kontroller;

import no.hvl.dat109.objekt.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReservasjonsMeny {

    /**
     * Metode der alt av input til en reservasjon skjer
     * @param bilUtS
     */
    public void ReserverMeny(Bilutleieselskap bilUtS){

        Scanner scanner = new Scanner(System.in);

        //Må først søke etter et utleiekontor/flyplass for leie og retur
        System.out.println("Skriv ønsket utleiekontor/flyplass: ");
        String leieKontor = scanner.nextLine();

        System.out.println("Skriv ønsket returkontor: ");
        String returKontor = scanner.nextLine();

        System.out.println("Ønsket dato: ");
        String onsketDato = scanner.nextLine();
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate utleieDato = LocalDate.parse(onsketDato, formatter);

        System.out.println("Ønsket klokkeslett: ");
        String onsketKl = scanner.nextLine();
        formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime utleieKl = LocalTime.parse(onsketKl, formatter);

        System.out.println("Ønsket antall dager: ");
        int antDag = scanner.nextInt();


        // Finner alle ledige biler til ønsket utleiekontor/flyplass og kunden finner ønsket bil

        List<Utleiekontor> utleiekontorListe = bilUtS.getUtleiekontorList();
        System.out.println("Kontorer: ");
        for(Utleiekontor utleiekontor : utleiekontorListe){
            System.out.println(utleiekontor.getAdresse().getPoststed());
        }

        Utleiekontor utk = utleiekontorListe.stream().filter(x -> leieKontor.equals(x.getAdresse().getPoststed())).findAny().orElse(null);

        Utleiekontor retK = utleiekontorListe.stream().filter(x -> returKontor.equals(x.getAdresse().getPoststed())).findAny().orElse(null);

        List<Bil> bilListe = utk.getBilListe();
        List<Bil> ledigeBiler = bilListe.stream().filter(x -> x.isLedig() == true).collect(Collectors.toList());
        ledigeBiler.forEach(System.out::println);

        System.out.println("Angi registreringsnummer for ønsket bil (A = liten, B = mellomstor, C = stor, D = stasjonsvogn");
        scanner.nextLine();
        String regnr = scanner.nextLine();

        Bil bil = ledigeBiler.stream().filter(x -> regnr.equals(x.getRegnr())).findAny().orElse(null);
        if(bil == null){
            System.out.println("Ops, feil regnr");
        }


        // Registrering av kunde.

        System.out.println("Fornavn: ");
        String fNavn = scanner.nextLine();

        System.out.println("Etternavn: ");
        String eNavn = scanner.nextLine();

        System.out.println("Adresse (gatenavn, postnr, poststed): ");
        String gatenavn = scanner.nextLine();
        int postnr = scanner.nextInt();
        scanner.nextLine();
        String poststed = scanner.nextLine();
        Adresse adresse = new Adresse(gatenavn,postnr,poststed);

        System.out.println("Telefonnummer: ");
        int tlfnr = scanner.nextInt();

        // Reservering av bil.

        Kunde kunde = new Kunde(fNavn,eNavn,adresse,tlfnr);
        Reserver res = new Reserver(kunde,bil,utk,retK,utleieDato,utleieKl,antDag);
        bilUtS.leggTilReservasjon(tlfnr,res);
//        bilUtS.nyReservasjon(res);
        res.reserverBil(bil);
        System.out.println("Reservasjonen din er: ");
        System.out.println(res.toString());
        int pris = bil.getPris()*antDag;

        if(utk != retK){
            System.out.println("Køsta ekstra å ver kar");
            pris += 500;
        }
        System.out.println("Pris for leie blir: " + pris);

        Main.klient();
    }
}
