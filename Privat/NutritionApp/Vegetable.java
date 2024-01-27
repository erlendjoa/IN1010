import java.util.HashMap;
import java.util.HashSet;

public class Vegetable extends Food {
    
    public Vegetable(HashMap<String, Food> foodLibrary, int id, String name) {
        super(foodLibrary, id, name);
    }
}