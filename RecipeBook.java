import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class RecipeBook {
    public static void main(String[] args) throws IOException {

        Recipe myChoice = Recipe.parseFile(RecipeBook.recipeSelector());
        System.out.println("\n" + myChoice.title);
        System.out.println("\n" + myChoice.ingredients);
    }

    // Clean up names that are printed on the console so they don't contain .txt or hyphens
    /***
     * Call accessFolder method, prints recipe options to console
     * and then prompts user for a recipe choice 
     * @return the recipe name
     */
    public static String recipeSelector() {
        ArrayList<String> recipeNames = Recipe.accessFolder();
        Scanner input = new Scanner(System.in);
        int userSelection = 0;
        String recipe = "";

        System.out.println("\nPlease choose a recipe:\n");

        for(int i = 0; i <= recipeNames.size() - 1; i++) {
            System.out.println((i + 1) + ". " + Recipe.formatFileName(recipeNames.get(i)));
        }
        System.out.print("\nYour choice: ");
        userSelection = input.nextInt();

        switch(userSelection) {
            case 1:
                recipe = recipeNames.get(0);
                break;
            case 2:
                recipe = recipeNames.get(1);
                break;
            default:
                recipe = "No selection made";
                break;
        }
        input.close();
        return recipe;
    }
}
