package forelesning;

public class TestAliste {
    public static void main(String[] args) {

        Aliste <Integer, String> tallListe = new Aliste <Integer, String>();

        tallListe.settInn(1, "VERDI1");
        tallListe.settInn(2, "VERDI2");
        tallListe.settInn(3, "VERDI3");
        System.out.println(tallListe.hentStr());    // : 1

        tallListe.sett(3, "NY VERDI!");
        tallListe.fjern(2);
        
        System.out.println(tallListe);
    }
}
