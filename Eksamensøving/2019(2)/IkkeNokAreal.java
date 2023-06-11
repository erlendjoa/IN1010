public class IkkeNokAreal extends Exception {
    public IkkeNokAreal(String ex) {
        super("Ikke nok areal for verdien " + ex + ".");
    }
}
