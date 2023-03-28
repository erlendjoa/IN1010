public class TestForm {
    public static void main(String[] args) {
        Firkant f = new Firkant(20);
        Kvadrat k = new Kvadrat(10);

        if ((f instanceof Form) && (k instanceof Firkant)) {
            System.out.println(f.type + " og " + k.type + " er gyldige.");
        }

        f.skrivUtOmkrets();
        k.skrivUtType();
    }
}
