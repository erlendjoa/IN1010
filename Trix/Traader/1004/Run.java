

public class Run implements Runnable {

    private final Bank b;
    private final int t;
    

    public Run(Bank b, int t) {
        this.b = b;
        this.t = t;
    }
    
    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            b.gi(t);
            b.ta(t);
            System.out.println(b.saldo());
        }
        
    }
}