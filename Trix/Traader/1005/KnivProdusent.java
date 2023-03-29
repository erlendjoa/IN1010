public class KnivProdusent implements Runnable{

    KnivMonitor monitor;
    int antallKniver;

    public KnivProdusent(KnivMonitor monitor, int antallKniver) {
        this.monitor = monitor;
        this.antallKniver = antallKniver;
    }

    @Override
    public void run() {
        for (int i = 0; i < antallKniver; i++) {
            Kniv kniv = new Kniv();
            monitor.settInnKniv(kniv);
        }
    }
    
}
