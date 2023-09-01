import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

public class Recipe {
   	String title;
   	ArrayList<String> ingredients;
	String instructions;

    /***
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
     * @param recipeName name of the file to be parsed
     * @return a Recipe Object
     * @throws IOException if the file name provided doesn't match
     */
    public static Recipe parseFile(String recipeName) throws IOException {
        int instructionStart = 0;
        String recipeFile = Files.readString(Paths.get("/Users/wigglesworth/Documents/Projects/Recipe_Book/RecipesList/" + recipeName));
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
	 * Access files in the RecipesList folder to be used by parseFile() and recipeSelector()
	 * @return an ArrayList comprised of the recipe names
	 */
   	public static ArrayList<String> accessFolder() {
      File folder = new File("/Users/wigglesworth/Documents/Projects/Recipe_Book/RecipesList/");
	  File[] fileNames = folder.listFiles();
	  ArrayList<String> recipeNames = new ArrayList<String>();
	  for(int i = 0; i <= fileNames.length - 1; i++) {
		recipeNames.add(fileNames[i].getName());
	  }

	  return recipeNames;
   	}
    
    /***
     * Takes a file name and formats it to a user-friendly view by removing certain special
     * characters
     * @param name a file to be formatted
     * @return a formatted file name without specified special characters and file extensions
     */
    public static String formatFileName(String name) {
        String formattedName = "";
        if(name.endsWith(".txt")) {
            String removeSuffix = name.substring(0, name.lastIndexOf("."));
            formattedName = removeSuffix.replace("-", " ");
        }
        return formattedName;
    }

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