import java.io.IOException;

public class RecipeBook {
    public static void main(String[] args) throws IOException {
        // Need to fix loop so user can continuously select recipes until -1 is read
        Recipe myFirstRecipe = Recipe.parseFile(Recipe.recipeSelector());
        if(!myFirstRecipe.isValid()) {
            System.out.println("Exiting...");
        }
        else {
            System.out.println("\n" + myFirstRecipe.getTitle());
            System.out.println("\n" + myFirstRecipe.getIngredients());
            System.out.println("\n" + myFirstRecipe.getInstructions());
        }
    }
}
