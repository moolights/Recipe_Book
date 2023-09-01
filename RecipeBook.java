import java.io.IOException;

public class RecipeBook {
    public static void main(String[] args) throws IOException {
        Recipe myChoice = Recipe.parseFile(Recipe.recipeSelector());
        System.out.println("\n" + myChoice.title);
        System.out.println("\n" + myChoice.ingredients);
    }
}
