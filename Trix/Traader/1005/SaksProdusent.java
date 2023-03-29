public class SaksProdusent implements Runnable{

    KnivMonitor knivMonitor;
    SaksMonitor saksMonitor;

    public SaksProdusent(KnivMonitor knivMonitor, SaksMonitor saksMonitor) {
        this.knivMonitor = knivMonitor;
        this.saksMonitor = saksMonitor;
    }
    
    @Override
    public void run() {
        Kniv[] tempKniver = knivMonitor.taUtKniver();
        while (tempKniver != null) {
            Saks nySaks = new Saks(tempKniver[0], tempKniver[1]);
            saksMonitor.settInnSaks(nySaks);
        }
        System.out.println(saksMonitor.hentAntSakser());
    }
}
