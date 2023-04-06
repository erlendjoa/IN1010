public class SaksProdusent implements Runnable{

    KnivMonitor knivMonitor;
    SaksMonitor saksMonitor;
    private Saks nySaks;

    public SaksProdusent(KnivMonitor knivMonitor, SaksMonitor saksMonitor) {
        this.knivMonitor = knivMonitor;
        this.saksMonitor = saksMonitor;
    }
    
    @Override
    public void run() {
        Kniv[] tempKniver = knivMonitor.taUtKniver();
        while (tempKniver != null) {
            nySaks = new Saks(tempKniver[0], tempKniver[1]);
            saksMonitor.settInnSaks(nySaks);
            tempKniver = knivMonitor.taUtKniver(); 
        }
    }
}