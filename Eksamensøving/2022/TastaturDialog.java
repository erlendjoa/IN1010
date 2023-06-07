import java.util.Scanner;

public class TastaturDialog implements Dialog {

    Scanner scanner = new Scanner(System.in);
    
    public boolean svarJaEllerNei(String spoersmaal) {
        System.out.println(spoersmaal + "\n| j/n: ");
        String svar = scanner.nextLine();
        scanner.close();
        if (svar.equals("j")) {
            return true;
        } else {
            return false;
        }
    }
}
