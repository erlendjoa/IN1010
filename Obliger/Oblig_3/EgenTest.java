public class EgenTest {
    public static void main(String[] args) {

        Prioritetskoe <Integer> pKoe = new Prioritetskoe<>();

        pKoe.leggTil(1);
        pKoe.leggTil(5);
        pKoe.leggTil(2);
        pKoe.leggTil(2);
        pKoe.leggTil(9);
        pKoe.leggTil(7);

        System.out.println(pKoe);

    }
}