package no.hvl.dat109.test;

import no.hvl.dat109.objekt.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestKlasse {

    private static Bilutleieselskap bus = new Bilutleieselskap("ProgBois superCars", 42060420,
            new Adresse("MartinsKongeGate", 1234, "Sykkylven"));
    private static Utleiekontor bergen = new Utleiekontor(bus, new Adresse("Flesland", 0001, "Bergen"),
            12345678);
//    private Bil bil = new Bil("EF99999","Volvo", "240", "Grå", Utleiergruppe.D);
//    private Kunde kunde = new Kunde("Martin", "Eliassen", new Adresse("Stor",1111,"Store"),12345678);

    private Bil bil;
    private Kunde kunde;

    @BeforeEach
    public void lagAlt(){
        bil = new Bil("EF99999","Volvo", "240", "Grå", Utleiergruppe.D);
        kunde = new Kunde("Martin", "Eliassen", new Adresse("Stor",1111,"Store"),12345678);
        Reserver res = new Reserver(kunde,bil,bergen, bergen, LocalDate.now(), LocalTime.now(), 2);
    }

    @Test
    public void testReservasjon(){
//        Bil bil = new Bil("EF99999","Volvo", "240", "Grå", Utleiergruppe.D);
//        Kunde kunde = new Kunde("Martin", "Eliassen", new Adresse("Stor",1111,"Store"),12345678);
        Reserver res = new Reserver(kunde,bil,bergen, bergen, LocalDate.now(), LocalTime.now(), 2);
        res.reserverBil(bil);

        assertFalse(bil.isLedig());
    }

    @Test
    public void testReturnerBil(){
        Reserver res = new Reserver(kunde,bil,bergen,bergen,LocalDate.now().minusDays(1), LocalTime.now().minusHours(24), 1);
        res.reserverBil(bil);
        Returner ret = new Returner(LocalDate.now(), LocalTime.now(),300);
        bus.leggTilRetur(12345678,ret);

        assertTrue(bil.isLedig());
    }

    @Test
    public void sjekkReservasjon(){
        Reserver res = new Reserver(kunde,bil,bergen, bergen, LocalDate.now(), LocalTime.now(), 2);
        res.reserverBil(bil);
        bus.leggTilReservasjon(kunde.getTlfnr(),res);


        assertEquals(res, bus.getReservasjon(12345678));

    }

}
