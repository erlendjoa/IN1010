import java.util.Random;
import java.util.ArrayList;

public class Cactpot {

    private final Random random = new Random();
    private ArrayList<Integer> randInts = new ArrayList<>();
    protected int[] cacts = new int[9];
    private String[] playerCacts = new String[9];

    public Cactpot() {
        for (int i = 1; i < 10; i++) {
            randInts.add(i);
        }
        for (int i = 0; i < 9; i++) {
            int randIndex = random.nextInt(randInts.size());
            cacts[i] = randInts.get(randIndex);
            randInts.remove(randIndex);
        }
    }

    public static void main(String[] args) {
        Cactpot cp = new Cactpot();
        for (int i = 0; i < cp.cacts.length; i++) {
            System.out.println(cp.cacts[i]);
        }
    }
}