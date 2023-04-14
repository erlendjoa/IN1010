import java.util.Scanner;

public class Main {

    User user;

    public static void main(String[] args) {
        Main main = new Main();

        StartThreads.main();
        main.createUser(args);
        main.createGui();
    }
    
    public void createUser(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("| Spotify Terminal |   Press Enter to continue: ");
        String startInput = scanner.nextLine();

        if (args[2].equals("premium")) {
            user = new PremiumUser(args[0], args[1]);
        } else {
            user = new FreeUser(args[0], args[1]);
        }
    }

    public void createGui() {

    }

    
}
