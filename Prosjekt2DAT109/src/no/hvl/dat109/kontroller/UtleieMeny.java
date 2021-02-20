package no.hvl.dat109.kontroller;

import no.hvl.dat109.objekt.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UtleieMeny {

    public void leiBil(Bilutleieselskap bus){

        Scanner scanner = new Scanner(System.in);

        //Gir tlfnr slik vi kan bruke hashmappen til å finne reservasjonen.
        System.out.println("Angi telefonnummer for å få reservasjonen: ");
        int tlfnr = scanner.nextInt();
        Reserver res = bus.getReservasjon(tlfnr);
        Bil bil = res.getBil();

        //Lager nytt kredittkort objekt
        System.out.println("Gi kredittkort nummer: ");
        int kredittK = scanner.nextInt();
        Kredittkort kred = new Kredittkort(kredittK);
        kred.setNummer(kredittK);

        //Antar lager nytt kredkort for hver utleie
        Kunde kunde = res.getKunde();
        kunde.setKredittkort(kred);

        //Får tak i info om reservasjon til en utleie
        String regnr = bil.getRegnr();
        int kmstand = bil.getKmstand();
        LocalDate utleieD = res.getOnsketDato();
        LocalDate returD = res.getOnsketDato().plusDays(res.getAntDag());
        LocalTime returKl = res.getOnsketKlSlett().plusHours(24*res.getAntDag());

        //Oppretter ny utleie av bil og legger til i liste over utleinger
        Utleie utleie = new Utleie(kred, bil, utleieD, returD, returKl);
        bus.leggTilUtleie(tlfnr,utleie);
        System.out.println("Bilen er leid!");

        Main.klient();
    }
}
