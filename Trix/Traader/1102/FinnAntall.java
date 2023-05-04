import java.util.Scanner;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class FinnAntall {

    public static void main(String[] args)  {

        //Henter argumenter fra terinal
        String ordSomSkalFinnes = args[0];
        String filnavn = args[1];
        int antallTraader = Integer.parseInt(args[2]);

        //Leser fra fil
        Scanner scn = null;
        try {
            scn = new Scanner(new File(filnavn));
        }
        catch (Exception e){ System.out.println(e);}

        int antallLinjer = scn.nextInt();
        scn.nextLine();

        String[] listeOrd = new String[antallLinjer];
        int indeks = 0;
        while (scn.hasNextLine()) {
            String ord = scn.nextLine();
            listeOrd[indeks] = ord;
            indeks++;
        }

        // hver tråd trenger en referanse til en CountDownLatch og en monitor.
        CountDownLatch cdl = new CountDownLatch(antallTraader);
        OrdMonitor monitor = new OrdMonitor();
        int ordPaaHverTraad = antallLinjer/antallTraader;
        indeks = 0;

        // deler opp listen med ord og oppretter trådene
        for (int i = 0; i < antallTraader; i++) {
            int antallord;
            if (i == antallTraader-1) antallOrd = antallLinjer - indeks;    // Hæ???
            else antallOrd = ordPaaHverTraad;
        }
    }
}