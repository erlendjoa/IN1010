public class Main {
    
    public static void main(String[] args) {
        BilKollektiv bilKollektiv = new BilKollektiv(10);
        for (int i=0; i<4; i++) {
            bilKollektiv.lagBilPris(new Personbil("13128398123", 250000));
            bilKollektiv.lagBilPris(new Varebil("83278414372", 560000));
        }
        TastaturDialog td = new TastaturDialog();
    }
}
