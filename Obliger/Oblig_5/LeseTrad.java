import java.io.File;
import java.util.HashMap;

public class LeseTrad implements Runnable, GlobalConstant {

    private final Monitor2 monitor;
    private final File fil;

    public LeseTrad(Monitor2 monitor, File fil) {
        this.monitor = monitor;
        this.fil = fil; }

    @Override
    public void run() {
        HashMap<String,Subsekvens> hashMap = monitor.lesFil(fil);
        monitor.settInn(hashMap);
    } 
}