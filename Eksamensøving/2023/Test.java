public class Test {
    public static void main(String[] args) {

        Tog tog = new Tog();
        Lokomotiv lokomotiv = new Lokomotiv("0", 5);
        Passasjervogn p1 = new Passasjervogn("1", 5, 10, 30);
        Passasjervogn p2 = new Passasjervogn("2", 5, 10, 30);
        Passasjervogn p3 = new Passasjervogn("3", 5, 10, 30);
        Passasjervogn p4 = new Passasjervogn("4", 5, 10, 30);
        Passasjervogn p5 = new Passasjervogn("5", 5, 10, 30);
        Godsvogn g1 = new Godsvogn("6", 5, 10, 10.0);
        Godsvogn g2 = new Godsvogn("7", 5, 10, 10.0);

        // ALLE LEGG TIL VIRKER
        tog.leggTil(lokomotiv);
        tog.leggTil(p1);
        tog.leggTil(p2);
        tog.leggTil(p3);
        tog.leggTilForan(p3, g1);
        tog.leggTilForan(p1, g2);
        try {
            tog.leggTilSikker(p4);    
            tog.leggTilSikker(p5);  
        } catch (FeilSporvidde e) {};
        
        // TA UT VIRKER NESTEN
        tog.finnOgTaUt("5");   
        tog.finnOgTaUt("4");
        tog.taUt(g2);

        // ITERATOR VIRKER 
        for (Skinnegaaende sg : tog) {
            System.out.println(sg.id);
        } System.out.println();

        // SJEKKREKURSIVT VIRKER NESTEN
        try {
            tog.sjekkRekursivt(); 
            tog.sjekkSporviddeRekursivt(p2);
        } catch (FeilSporvidde e) {};

        // hentPassasjervogner() VIRKER
        for (Passasjervogn p : tog.hentPassasjervogner()) {
            System.out.println(p.id);
        } System.out.println();


        Monitor monitor = new Monitor(3); 
        Thread leter1 = new Thread(new Leter(tog, monitor, "1"));
        Thread leter2 = new Thread(new Leter(tog, monitor, "2"));
        Thread leter3 = new Thread(new Leter(tog, monitor, "3"));
        Thread resultat = new Thread(new Resultat(monitor));
        resultat.start();
        leter1.start();
        leter2.start();
        leter3.start();
        
        System.out.println(tog);
    }
}
