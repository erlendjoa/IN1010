

public class Main {
    
    public static void main(String[] args) {
        Bank b = new Bank(10000);

        for (int i = 10; i < 100; i+=10) {
            Run run = new Run(b, i);
            Thread traad = new Thread(run);
            traad.start();
        }
    }
}
