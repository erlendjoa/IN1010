import java.util.HashMap;
import java.util.ArrayList;

public class FletteTrad implements Runnable {
    
    Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor; }

    @Override
    public void run() {
        while (monitor.subRegister.hentAnt() >= 2) {
            try {
                while (monitor.subRegister.hentAnt() < 2) {
                    monitor.cond.await(); }
                ArrayList<HashMap<String,Subsekvens>> hashMapArr = monitor.hentTo();
                HashMap<String,Subsekvens> flettetHM = SubsekvensRegister.settSammen(hashMapArr.get(0), hashMapArr.get(1)); 
                monitor.settInn(flettetHM); }

            catch (InterruptedException | IndexOutOfBoundsException e) {
                System.out.println("= CACHED = " + e);
            }
        } 
    }
}