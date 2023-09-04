import java.io.IOException;

public class RecipeBook {
    public static void main(String[] args) throws IOException {
        Recipe myChoice = Recipe.parseFile(Recipe.recipeSelector());
        // if first input is -1, then an empty recipe object is returned causing null title and ingredients... fix this
        if(!myChoice.isValid()) {
            System.out.println("Gotcha");
        }
        else {
            System.out.println("\n" + myChoice.title);
            System.out.println("\n" + myChoice.ingredients);
        }
        
    }
}
