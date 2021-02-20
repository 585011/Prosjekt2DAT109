package no.hvl.dat109.kontroller;

import no.hvl.dat109.objekt.Adresse;
import no.hvl.dat109.objekt.Bilutleieselskap;
import no.hvl.dat109.objekt.Utleiekontor;

import java.util.Scanner;

public class Main {
    private static Bilutleieselskap bus = new Bilutleieselskap("ProgBois superCars", 42060420,
            new Adresse("MartinsKongeGate", 1234, "Sykkylven"));
    private static Utleiekontor bergen = new Utleiekontor(bus, new Adresse("Flesland", 0001, "Bergen"),
            12345678);
    private static Utleiekontor Aalesund = new Utleiekontor(bus, new Adresse("Vigra", 1010, "Aalesund"),
            87654321);

    public static void main(String[] args) {

        AlleBilene ab = new AlleBilene();
        bergen.setBilListe(ab.lagBilUtvalg());
        Aalesund.setBilListe(ab.lagBilUtvalg());
        bus.leggTilUtleiekontor(bergen);
        bus.leggTilUtleiekontor(Aalesund);

        Main.klient();

    }

    /**
     * Metode for å starte alle menyene for: reservasjon, utleie, retur
     */
    public static void klient(){
        ReservasjonsMeny resM = new ReservasjonsMeny();
        UtleieMeny utlM = new UtleieMeny();

        Scanner scanner = new Scanner(System.in);

        //Ber kunde angi kva han/ho vil gjer med bilen
        System.out.println("Meny for bilutleie. Skriv tall fra 1 til 4 for kva du vil gjer: ");
        System.out.println("1 for å reservere bil");
        System.out.println("2 for å leie bil");
        System.out.println("3 for å returnere bil");
        System.out.println("4 for å avslutte");

        int menyValg = scanner.nextInt();
        boolean ferdig = false;
        while(!ferdig){
        switch(menyValg) {
            case 1:
                resM.ReserverMeny(bus);
                break;
            case 2:
                utlM.leiBil(bus);
                break;
            case 4:
                System.out.println("Avslutter tjenesten.");
                ferdig = true;
//                System.exit(0);
                break;
            default:
                System.out.println("Oops, ka som skjedde her? *thinking*");
        }
        }
        System.exit(0);
    }
}
