public class Kvadrat extends Firkant{
    protected String type;
    protected int omkrets;

    
    public Kvadrat(int omkrets_) {
        super(omkrets_);    // deklarerer omkrets til Kvadrat gjennom rammeverket for kontruktør i Kradrat.
        type = "Kvadrat";
    }

    public void skrivUtOmkrets() {
        System.out.println(omkrets);
    }

    @Override
    public void skrivUtType() {
        System.out.println(type);
    }
}
