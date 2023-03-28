import java.util.HashMap;
import java.util.Scanner;

public class Telefonbok {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> tlfBok = new HashMap<>();

        tlfBok.put("Arne", "22334455");
        tlfBok.put("Lisa", "95959595");
        tlfBok.put("Jonas", "97959795");
        tlfBok.put("Peder", "12345678");

        String inp = "s";
        while (!inp.equals("q")) {
            System.out.println("Skriv navn på person: ('q' for aa avslutte)");
            inp = scanner.nextLine();
            if (tlfBok.containsKey(inp)) {
                System.out.println(tlfBok.get(inp));
                break;
            }
        }
        scanner.close();

        for (String navn : tlfBok.keySet()) {
            System.out.println(navn + ": " + tlfBok.get(navn));
        }
    }
}