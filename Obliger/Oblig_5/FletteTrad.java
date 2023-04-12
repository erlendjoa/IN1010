import java.util.HashMap;

public class FletteTrad implements Runnable {
    
    Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor; }

    @Override
    public void run() {
        while (monitor.subRegister.hentAnt() >= 2) {
            try {
                HashMap<String,Subsekvens> hM1 = monitor.fjern();
                HashMap<String,Subsekvens> hM2 = monitor.fjern(); 
                HashMap<String,Subsekvens> flettetHM = SubsekvensRegister.settSammen(hM1, hM2); 
                monitor.settInn(flettetHM); }

            catch (InterruptedException | IndexOutOfBoundsException e) {
                System.out.println("= CACHED = " + e);
            }
        } 
    }
}