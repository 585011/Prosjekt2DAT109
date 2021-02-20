package no.hvl.dat109.kontroller;

import no.hvl.dat109.objekt.Bil;
import no.hvl.dat109.objekt.Bilutleieselskap;
import no.hvl.dat109.objekt.Returner;
import no.hvl.dat109.objekt.Utleie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class ReturMeny {

    public void returnerBil(Bilutleieselskap bus){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Angi telefonnummer for å returnere bilen: ");
        int tlfnr = scanner.nextInt();

        Utleie utleie = bus.getUtleie(tlfnr);

        if(utleie == null){
            System.out.println("finner ikke utleien, feil tlfnr eller ikke leid bil");
        }
        Bil bil = utleie.getBil();

        LocalDate returDato = utleie.getUtleieDato();
        LocalTime returKl = utleie.getReturKl();
        Random rnd = new Random();
        int kmstand = rnd.nextInt(3000) + 100;

        Returner returner = new Returner(returDato, returKl, kmstand);
        bus.leggTilRetur(tlfnr,returner);

        System.out.println("Bil returnert! Velkommen tilbake til ProgBois superCars.");

        Main.klient();

    }
}
