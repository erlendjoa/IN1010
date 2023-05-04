import java.util.ArrayList;

public class Teddybjornspill {
    
    ArrayList<String> nArr;

    public int teddybjornspill(int n) {
        System.out.println(n);
        if (!nArr.contains(String.valueOf(n))) {
            nArr.add(Integer.toString(n));
            if (n % 5 == 0) return 42;
            if (n % 2 == 0) return teddybjornspill(n/2);
            if (n % 3 == 0 || n % 4 == 0) return teddybjornspill((n%100)/10 + n%10);
        }
        return 0;
    }

    public boolean teddy(int n) {
        nArr = new ArrayList<>();
        if (teddybjornspill(n) == 42) {
            return true; 
        }
        return false;
    }

    public static void main(String[] args) {
        Teddybjornspill tbs = new Teddybjornspill();
        System.out.println(tbs.teddy(250));
        System.out.println(tbs.teddy(208));
        System.out.println(tbs.teddy(84));
        System.out.println(tbs.teddy(53));
        System.out.println(tbs.teddy(41));
    }
}