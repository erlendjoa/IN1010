public class EgetInventar extends Inventar {

    int innkjopsaar;
    
    public EgetInventar(String n, int v, int innkjopsaar) {
        super(n, v);
        this.innkjopsaar = innkjopsaar;
    }

    @Override
    public int finnForsikringsverdi() {
        double d = verdi*0.8;
        return (int) d;
    }
}
