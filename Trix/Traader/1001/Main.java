public class Main {
    
    public static void main(String[] args) {
        
        Monitor monitor = new Monitor();

        N n = new N(monitor, 100000);
        O o = new O(monitor, 1);
        Thread nedover = new Thread(n);
        Thread oppover = new Thread(o);

        nedover.start();
        oppover.start();
    }
}
