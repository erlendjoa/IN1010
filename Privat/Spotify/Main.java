import java.util.Scanner;

public class Main {

    public Main() {
        Main main = new Main();

        //StartThreads.main();
        main.startUp();
    }
    
    public static void startUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("| Spotify Terminal |   Press Enter to continue: ");
        String startInput = scanner.nextLine();

        System.out.println("Insert username: ");
        String username = scanner.nextLine();
        System.out.println("Insert password: ");
        String password = scanner.nextLine();

        System.out.println(username + password);
    }

    
}
