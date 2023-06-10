//5A:
public class Leter implements Runnable {
    
    Tog tog;
    Monitor monitor;
    String valgtId;
    
    public Leter(Tog tog, Monitor monitor, String valgtId) {
        this.tog = tog;
        this.monitor = monitor;
        this.valgtId = valgtId;
    }
    
    @Override
    public void run() {
        Skinnegaaende tempSG = tog.hode;
        while (true) {
            if (tempSG.hentId().startsWith(valgtId)) {
                monitor.leggTil(tempSG);
            }
            if (tempSG == tog.hale) {
                monitor.ferdigLeting();
                break;
            }
            tempSG = tempSG.neste;
        }
    }
}