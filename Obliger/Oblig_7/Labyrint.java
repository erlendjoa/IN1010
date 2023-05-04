import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrint {

    private Rute[][] labyrint;

    public Labyrint(File fil) {
        try {
            Scanner scn = new Scanner(fil);  

            // Initier Rute[][] med første linje i fil.
            String antRadKol = scn.nextLine();
            labyrint = new Rute[Integer.parseInt(antRadKol.split(" ")[0])][Integer.parseInt(antRadKol.split(" ")[1])];

            // Fyll med sorte og hvite ruter.
            int i = 0;
            while (scn.hasNextLine()) {

                String linje = scn.nextLine();
                for (int j = 0; j < linje.length(); j++) {
                    if (linje.charAt(j) == '#') {
                        labyrint[i][j] = new SortRute(labyrint, i, j);
                    }
                    else {
                        labyrint[i][j] = new HvitRute(labyrint, i, j);
                    }
                }
                i++;
            }

            // Let etter og initier Aapninger.
            for (int rad = 0; rad < labyrint.length; rad++) {
                for (int kol = 0; kol < labyrint[rad].length; kol++) {
                    if ((rad == 0 || rad == labyrint.length-1 || kol == 0 || kol == labyrint[rad].length-1) && (labyrint[rad][kol].toString().equals("hvit"))) {
                        labyrint[rad][kol] = new Aapning(labyrint, rad, kol);
                    }
                }
            }

            scn.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil.");
            return;
        }

        //Sett naboer.
        for (int rad = 0; rad < labyrint.length; rad++) {
            for (int kol = 0; kol < labyrint[rad].length; kol++) {
                try {
                    labyrint[rad][kol].naboer[0] = labyrint[rad-1][kol]; }
                catch (IndexOutOfBoundsException e){}
                try {
                    labyrint[rad][kol].naboer[1] = labyrint[rad][kol+1]; }
                catch (IndexOutOfBoundsException e){}
                try {
                    labyrint[rad][kol].naboer[2] = labyrint[rad+1][kol]; }
                catch (IndexOutOfBoundsException e){}
                try {
                    labyrint[rad][kol].naboer[3] = labyrint[rad][kol-1]; }
                catch (IndexOutOfBoundsException e){}
            }
        }
        System.out.println(this);
    }

    public void finnUtveiFra(int rad, int kol) {
        try {
            if (labyrint[rad][kol].toString().equals("sort")) {
                System.out.println("Kan ikke starte i sort rute");
            } else {
                labyrint[rad][kol].finn(null); 
            }
            
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Ikke en gyldig ruteplassering");
        }
    }

    @Override
    public String toString() {
        String string = "";
        for (int rad = 0; rad < labyrint.length; rad++) {
            for (int kol = 0; kol < labyrint[rad].length; kol++) {
                if (labyrint[rad][kol].toString() == "sort") {
                    string += "#"; 
                } else {
                    string += ".";
                }
            }
            string += "\n";
        }
        return string;
    }
}