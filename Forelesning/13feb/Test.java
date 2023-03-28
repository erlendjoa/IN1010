public class Test {
    public static void main(String[] args) {
        ElektriskBil elektriskBil = new ElektriskBil("SDG593", "Toyota", "Corolla 2003", 60);

        elektriskBil.lade(100);
        elektriskBil.skrivUt();
    }
}
