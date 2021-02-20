package no.hvl.dat109.objekt;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserver {
    private Kunde kunde;
    private Bil bil;
    private Utleiekontor utleieSted;
    private Utleiekontor returSted;
    private LocalDate onsketDato;
    private LocalTime onsketKlSlett;
    private int antDag;

    public Reserver(Kunde kunde, Bil bil, Utleiekontor utleieSted, Utleiekontor returSted,
                    LocalDate onsketDato, LocalTime onsketKlSlett, int antDag) {
        this.kunde = kunde;
        this.bil = bil;
        this.utleieSted = utleieSted;
        this.returSted = returSted;
        this.onsketDato = onsketDato;
        this.onsketKlSlett = onsketKlSlett;
        this.antDag = antDag;

        /*Då skjer reservasjon av bil når vi laga et nytt reserver objekt, istedefor at vi må gjer
        det etter at objektet er oppretta.
         */
//        reserverBil(bil);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Bil getBil() {
        return bil;
    }

    public Utleiekontor getUtleieSted() {
        return utleieSted;
    }

    public Utleiekontor getReturSted() {
        return returSted;
    }

    public LocalDate getOnsketDato() {
        return onsketDato;
    }

    public LocalTime getOnsketKlSlett() {
        return onsketKlSlett;
    }

    public int getAntDag() {
        return antDag;
    }

    /**
     * Reserverer en bil og sett ledig lik false, menst tiden nå er etter ønsket dato og før levering.
     * @param bil
     */
    public void reserverBil(Bil bil){
        LocalDate leverDato = onsketDato.plusDays(antDag);

        if (LocalDate.now().isBefore(leverDato)){
            bil.setLedig(false);
        }
    }

    @Override
    public String toString() {
        return "Reserver{" +
                "kunde=" + kunde +
                ", bil=" + bil +
                ", utleieSted=" + utleieSted +
                ", returSted=" + returSted +
                ", onsketDato=" + onsketDato +
                ", onsketKlSlett=" + onsketKlSlett +
                ", antDag=" + antDag +
                '}' + "\n";
    }
}
