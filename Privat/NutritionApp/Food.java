import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Food {
    final int id;
    final String name;

    int protein;
    int carbs;
    int fat;


    public Food(HashMap<String, Food> foodLibrary, int id, String name) {
        this.id = id;
        id++;

        this.name = name;
        foodLibrary.put(name, this);

        setNutrients();
    }

    
    public void setNutrients() {
        Scanner scn = new Scanner(System.in);

        // set protein amount
        System.out.println("Set protein amount: ");
        try {
            protein = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients();
        }

        // set fat amount
        System.out.println("Set fat amount: ");
        try {
            fat = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients();
        }

        // set carb amount
        System.out.println("Set carb amount: ");
        try {
            carbs = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients();
        }

        scn.close();
    }
}
