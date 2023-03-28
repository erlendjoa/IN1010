public class Main {
    
    public static void main(String[] args) {
        
        Monitor monitor = new Monitor();
        M m1 = new M(Monitor monitor, Integer.MAX_VALUE);
        M m2 = new M(Monitor monitor, Integer.MIN_VALUE);
        Thread nedover = new Thread(m1);
        Thread oppover = new Thread(m2);
    }
}
