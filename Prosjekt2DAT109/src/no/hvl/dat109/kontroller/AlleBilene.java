package no.hvl.dat109.kontroller;

import no.hvl.dat109.objekt.Bil;
import no.hvl.dat109.objekt.Utleiergruppe;

import java.util.ArrayList;
import java.util.List;

public class AlleBilene {

    public List<Bil> lagBilUtvalg(){

        List<Bil> bilUtvalg = new ArrayList<Bil>();

        Bil tesla = new Bil("EL140297","Tesla", "Model S", "Marine Blå", Utleiergruppe.B);
        bilUtvalg.add(tesla);
        Bil VW = new Bil("VG022021", "VW", "Caravelle", "Grøn",Utleiergruppe.D);
        bilUtvalg.add(VW);
        Bil lambo = new Bil("BT123456", "Lamborghini", "Aventador", "Oransj", Utleiergruppe.A);
        bilUtvalg.add(lambo);
        Bil saab = new Bil("SM111222", "Saab", "9-3","Grå", Utleiergruppe.C);
        bilUtvalg.add(saab);

        return bilUtvalg;
    }
}
