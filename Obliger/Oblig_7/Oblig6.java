import java.io.File;
import java.util.Scanner;

public class Oblig6 {

    public static void main(String[] args) {
        Labyrint labyrint = new Labyrint(new File(args[0]));
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Skriv inn koordinater til startrute (feks: 0,0): ");
        String koordinater = scn.nextLine();
        try {
            labyrint.finnUtveiFra(Integer.parseInt(koordinater.split(",")[0]), Integer.parseInt(koordinater.split(",")[1]));
        }
        catch (NumberFormatException e) {
            System.out.println("Ikke gydlig input");
        }
    }
}
