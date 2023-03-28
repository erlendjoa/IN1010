import java.util.*;

public class GameOfLife {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Rader: ");
        String rowInput = sc.nextLine();
        System.out.println("Kolonner: ");
        String colInput = sc.nextLine();


        Verden verden = new Verden(Integer.parseInt(rowInput), Integer.parseInt(colInput));
        verden.tegn();

        System.out.println("\nTrykk enter to continue: ");
        String input = sc.nextLine();


        while (input != "q") {

            verden.oppdatering();
            verden.tegn();

            System.out.println("\nTrykk enter to continue: ");
            input = sc.nextLine();
        }
        
        sc.close();
    }
}
