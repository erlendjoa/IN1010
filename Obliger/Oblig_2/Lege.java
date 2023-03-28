public class Lege {

    String navn;
    
    public Lege(String navn_) {
        navn = navn_;
    }

    public String hentNavn() {
        return navn;
    }


    @Override
    public String toString() {
        return "Navn: " + navn + "\n";
    }
}
