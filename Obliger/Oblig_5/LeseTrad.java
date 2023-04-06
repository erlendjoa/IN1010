import java.io.File;
import java.util.HashMap;

public class LeseTrad implements Runnable {

    Monitor1 monitor;
    File fil;

    public LeseTrad(Monitor1 monitor, String filnavn) {
        this.monitor = monitor;
        fil = new File(filnavn); }

    @Override
    public void run() {
        HashMap<String,Subsekvens> hashMap = SubsekvensRegister.lesFil(fil);
        monitor.settInn(hashMap);
    } 
}