import java.io.File;
import java.util.HashMap;

public class LeseTrad implements Runnable, GlobalInt {

    Monitor1 monitor;
    File fil;

    public LeseTrad(Monitor1 monitor, File fil) {
        this.monitor = monitor;
        this.fil = fil; }

    @Override
    public void run() {
        HashMap<String,Subsekvens> hashMap = SubsekvensRegister.lesFil(fil);
        monitor.settInn(hashMap);
    } 
}