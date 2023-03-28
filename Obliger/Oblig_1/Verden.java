

public class Verden {

    private int antRader;
    private int antKolonner;
    private Rutenett rutenett;
    private int genNr;

    public Verden(int _antRader, int _antKolonner) {
        antRader = _antRader;
        antKolonner = _antKolonner;
        rutenett = new Rutenett(antRader, antKolonner);
        genNr = 0;

        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }


    public void tegn() {
        rutenett.tegnRutenett();
        System.out.println("\n\nANT LEVENDE NABOER: " + rutenett.antallLevende());
        System.out.println("GEN: " + genNr);
    }

    public void oppdatering() {     // hovedmetoden som kjøres hver iterasjon. Teller levende naboer og utfra resultatet oppdaterer .levende.

        for (int i = 0; i < rutenett.antRader; i++) {
            for (int ii = 0; ii < rutenett.antKolonner; ii++) {
                rutenett.rutene[i][ii].tellLevendeNaboer();
            }
        }
        for (int i = 0; i < rutenett.antRader; i++) {
            for (int ii = 0; ii < rutenett.antKolonner; ii++) {
                rutenett.rutene[i][ii].oppdaterStatus();
            }
        }
        genNr++;
    }
}
