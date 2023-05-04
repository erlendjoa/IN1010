

public class Triangel {

    public static void main(String[] args) {
        Triangel.triangel(1, 8);
    }

    static void triangel(int m, int n) {    // m <= n
        String stars = "";
        for (int i = 0; i < m; i++) {
            stars += "*";
        }

        System.out.println(stars);
        if (m != n) {
            triangel(m + 1, n);
        }
        System.out.println(stars);
    }
}