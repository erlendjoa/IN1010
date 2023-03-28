

public class Pokemon {

    protected final String name;
    protected String[] types = new String[2];
    protected int health;
    protected int level;

    public final int id;
    private static int pokeIndex = 0;    // static is important here!

    protected int xp;
    protected int maxXp;

    protected Move[] moveset = new Move[4];

    public Pokemon(String name, String[] types, int health, int level) {
        this.id = pokeIndex;
        pokeIndex++;

        this.name = name;
        this.types = types;
        this.health = health;
        this.level = level;

        xp = 0;
        maxXp = level*100;
    }

    public void setMove(int i, Move move) {
        moveset[i-1] = move;
    }
    public Move getMove(int i) {
        return moveset[i-1];
    }
}