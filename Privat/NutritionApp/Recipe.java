import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Recipe {
    final int id;
    final String name;

    ArrayList<String> ingredients;
    ArrayList<String> steps;
    
    public Recipe(HashSet<String> recipeLibrary, int id, String name) {
        this.id = id;
        id++;

        this.name = name;
        recipeLibrary.add(name);
    }

    public void setIngredients(HashMap<String, Food> foodLibrary) {
        Scanner scn = new Scanner(System.in);
        String inp = "";
        String foodname = "";
        String amount = "";

        while (!inp.equals("q")) {
            System.out.println("Add ingredient (name of food) to recipe: ");
            foodname = scn.nextLine();
            if (!foodLibrary.containsKey(foodname)) {
                System.out.println("***INVALID INPUT***");
                setIngredients(foodLibrary);
            }
            System.out.println("Set amount (1 / 100g / 1 cup): ");
            amount = scn.nextLine();
            
            ingredients.add(foodname + ", " + amount);
        }

        scn.close();
    }
    
}
