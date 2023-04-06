import java.util.HashMap;

public class FletteTrad implements Runnable {
    
    Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor; }

    @Override
    public void run() {
        while (monitor.monitorRegister.size() >= 2) {
            try {
                HashMap<String,Subsekvens> hM1 = monitor.fjern(0);
                HashMap<String,Subsekvens> hM2 = monitor.fjern(0); 
                monitor.settSammen(hM1, hM2); }

            catch (InterruptedException | IndexOutOfBoundsException e) {
                System.out.println("= CACHED = " + e);
            } 
        } 
    }
}