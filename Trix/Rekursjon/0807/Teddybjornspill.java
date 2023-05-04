

public class Teddybjornspill {

    public static int teddybjornspill(int n) {
        if (n % 5 == 0) return 42;
        if (n % 2 == 0) return teddybjornspill(n/2);
        if (n % 3 == 0 || n % 4 == 0) return teddybjornspill((n%100)/10 + n%10);
        return 0;
    }

    boolean teddy(int n) {
        if (Teddybjornspill.teddybjornspill(n) == 42) {
            return true; 
        }
        return false;
    }

    public static void main(String[] args) {
        Teddybjornspill tbs = new Teddybjornspill();
        System.out.println(tbs.teddy(250));
        System.out.println(tbs.teddy(42));
        System.out.println(tbs.teddy(84));
        System.out.println(tbs.teddy(53));
        System.out.println(tbs.teddy(41));
    }
}