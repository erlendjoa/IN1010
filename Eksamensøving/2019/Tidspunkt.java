

public class Tidspunkt implements Comparable<Tidspunkt> {
    public int[] tid;

    public Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek) {
        int[] tid = {aar, mnd, dag, time, min, sek};
        this.tid = tid;
    }
    
    public int compareTo(Tidspunkt nyTidspunkt) {
        for (int i = 0; i < nyTidspunkt.tid.length; i++) {
            if (nyTidspunkt.tid[i] > tid[i]) {
                return 1;
            } else if (nyTidspunkt.tid[i] < tid[i]) {
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
    // TEST MAIN
    Tidspunkt tp1 = new Tidspunkt(5, 3, 30, 4, 45, 10);
    Tidspunkt tp2 = new Tidspunkt(4, 8, 31, 12, 10, 53);
    Tidspunkt tp3 = new Tidspunkt(5, 3, 30, 4, 45, 10);
    Tidspunkt tp4 = new Tidspunkt(5, 3, 30, 4, 44, 10);
    System.out.println(tp3.compareTo(tp4));
    }
}

