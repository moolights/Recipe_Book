import java.util.Scanner;
import java.io.IOException;

public class RecipeBook {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("What recipe are you searching for?");

        // Figure out how to print a list of the recipe files for a user to select from

        // Need to make selection based on a numbered list rather than text to avoid
        // input errors

        String recipeName = input.nextLine(); // Waits for user input
        Recipe recipe = Recipe.parseFile(recipeName); // Creates a recipe by calling parseFile()
        input.close(); // Closes Scanner

        // Recipe recipe = Recipe.parseFile(args[0]);

        /*
         * Prints out a formatted recipe
         */
        System.out.println();
        System.out.println(recipe.title + "\n");
        for(String ingredient : recipe.ingredients) {
            System.out.println("-" + ingredient);
        }
        System.out.println("\n" + recipe.instructions);
    }
}
