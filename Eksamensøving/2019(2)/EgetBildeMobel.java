public class EgetBildeMobel extends EgetInventar implements Bilde, Mobel {
    public EgetBildeMobel(String n, int v, int i) {
        super(n,v,i);
    }
    public int bredde() {
        return 0;
    }
    public int areal() {
        return 0;
    }
}
