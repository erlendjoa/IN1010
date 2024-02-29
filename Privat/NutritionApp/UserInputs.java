import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputs {
    

    public void setNutrients(Food food) {
        Scanner scn = new Scanner(System.in);

        // set protein amount
        System.out.println("Set protein amount: ");
        try {
            food.protein = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients(food);
        }

        // set fat amount
        System.out.println("Set fat amount: ");
        try {
            food.fat = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients(food);
        }

        // set carb amount
        System.out.println("Set carb amount: ");
        try {
            food.carbs = scn.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("*INVALID INPUT*");
            setNutrients(food);
        }

        scn.close();
    }

    public void setRecipe(Recipe recipe) {
        
    }
}
