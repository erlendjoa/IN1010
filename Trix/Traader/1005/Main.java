public class Main {
    
    public static void main(String[] args) {
        KnivMonitor knivMonitor = new KnivMonitor();
        SaksMonitor saksMonitor = new SaksMonitor();
        Thread[] knivProdusenter = {new Thread(new KnivProdusent(knivMonitor, 1000)), new Thread(new KnivProdusent(knivMonitor, 1000))};
        Thread[] saksProdusenter = {new Thread(new SaksProdusent(knivMonitor, saksMonitor)), new Thread(new SaksProdusent(knivMonitor, saksMonitor))};

        knivProdusenter[0].start();
        knivProdusenter[1].start();
        System.out.println("= Startet knivprodusenter...");

        try {
            knivProdusenter[0].join();
            knivProdusenter[1].join();
        } catch (InterruptedException e) {}
        System.out.println("- Knivprodusenter ferdig!");

        System.out.println("= Antall Kniver Produsert: " + knivMonitor.hentAntKniver());

        System.out.println("= Starter saksprodusenter...");
        saksProdusenter[0].start();
        saksProdusenter[1].start();
        
        try {
            saksProdusenter[0].join();
            saksProdusenter[1].join();
        } catch (InterruptedException e) {}
        System.out.println("- Saksprodusenter ferdig!");
        
        System.out.println("Antall Sakser Produsert: " + saksMonitor.hentAntSakser());
        System.out.println("=== PROGRAM HLT ===");
    }   
}