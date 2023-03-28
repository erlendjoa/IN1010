
public class Firkant extends Form {
    protected String type;
    protected int omkrets;

    public Firkant(int omkrets_) {
        omkrets = omkrets_;
        type = "Firkant";
    }

    public void skrivUtOmkrets() {
        System.out.println(omkrets);
    }

    @Override   // sender feilmelding om metode ikke er gyldig override.
    public void skrivUtType() {
        System.out.println(type);
    }
}