import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Recipe {
    String title;
    ArrayList<String> ingredients;
    String instructions;

    /**
     * Empty Constructor
     */
    public Recipe() {}

    /***
     * Constructor creates a recipe object
     * @param title name of the recipe
     * @param ingredients Array list of the ingredients in the recipe
     * @param instructions Instructions on how to prepare the recipe
     */
    public Recipe(String title, ArrayList<String> ingredients, String instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    /***
     * Parses a txt file containing a recipe into a Recipe object
     * @param file name of the file to be parsed
     * @return a Recipe Object
     * @throws IOException if the file name provided doesn't match
     */
    public static Recipe parseFile(String file) throws IOException {
        int instructionStart = 0;
        String recipeFile = Files.readString(Paths.get(file));
        String[] recipeLines = recipeFile.split("\n");

        String recipeTitle = recipeLines[0]; // Gets title of recipe
        ArrayList<String> ingredientList = new ArrayList<String>();
        String recipeInstructions = "";
        
        for(int i = 0; i <= recipeLines.length - 1; i++) {
            if(recipeLines[i].startsWith("-")) {
                ingredientList.add(recipeLines[i].replace("- ", ""));
            }
            if(recipeLines[i].equals("Recipe:")) {
                instructionStart = i;
            }
        }

        for(int i = instructionStart; i <= recipeLines.length - 1; i++) {
            recipeInstructions += recipeLines[i] + "\n";
        }

        Recipe recipe = new Recipe(recipeTitle, ingredientList, recipeInstructions);
        return recipe;

    }

    /***
     * Compares an ingredient on the recipe with a specified ingredient to check for an allergy
     * @param ingredients list of ingredients from the recipe
     * @param allergen specified ingredient by the user
     * @return true if the allergen matches or false if it doesn't
     */
    public boolean containsAllergen(ArrayList<String> ingredients, String allergen) {
        for(String ingredient : ingredients) {
            if(ingredient.equals(allergen)) {
                System.out.println("Ingredient: " + ingredient + "  " + allergen);
                return true;
            } 
        }
        return false;
    }
}