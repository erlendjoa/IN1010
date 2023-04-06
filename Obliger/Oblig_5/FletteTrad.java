import java.util.HashMap;

public class FletteTrad implements Runnable {
    
    Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor; }

    @Override
    public void run() {
        while (monitor.register.size() >= 2) {
            HashMap<String,Subsekvens> hM1 = monitor.register.remove(0);
            HashMap<String,Subsekvens> hM2 = monitor.register.remove(0);
            try {
                monitor.settInn(monitor.settSammen(hM1, hM2)); }
            catch (InterruptedException e) {} } }
}