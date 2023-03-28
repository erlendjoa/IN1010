public class Spesialist extends Lege implements Godkjenningsfritak{

    String kontrollKode;

    public Spesialist(String navn, String kontrollKode_) {
        super(navn);
        kontrollKode = kontrollKode_;
    }
    
    public String hentKontrollKode() {
        return kontrollKode;
    } 

    @Override
    public String toString() {
        return "Navn: " + navn + "\nKontrollkode: " + kontrollKode + "\n";
    }

}
