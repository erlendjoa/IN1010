public class IkkeNokBredde extends Exception {
    public IkkeNokBredde(String ex) {
        super("Ikke nok bredde for verdien " + ex + ".");
    }
}
