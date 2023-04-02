public class Main {
    
    public static void main(String[] args) {

        Postkontor postKontor = new Postkontor();

        for (int i = 0; i < 10; i++) {
            Postmann postmann = new Postmann(postKontor);
            Thread traad = new Thread(postmann);
            traad.start();
        }

        Kunde kaare = new Kunde(postKontor, "Kaare");
        Kunde mona = new Kunde(postKontor, "Mona");
        Kunde leif = new Kunde(postKontor, "Leif");
        Thread t1 = new Thread(kaare);
        Thread t2 = new Thread(mona);
        Thread t3 = new Thread(leif);

        t1.start();  t2.start(); t3.start();
        
        
    }
}
