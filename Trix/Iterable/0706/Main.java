public class Main {
    
    public static void main(String[] args) {
        Butikk butikk = new Butikk();
        for (int i=0; i<5; i++) {
            butikk.entreButikk(new Person("Harald", "Sølvskje"));
        }
        //butikk.kassa();

        for (Person p : butikk) {
            System.out.println(p.navn + p.gjenstand);
        }
    }
}
