public class Move {
    
    protected String type;
    protected int damage;
    protected int usage;

    public Move(String type, int damage, int usage) {
        this.type = type;
        this.damage = damage;
        this.usage = usage;
    }

    public void minusUsage() {
        usage--;
    }
}
