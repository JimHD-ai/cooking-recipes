import com.models.Recipe;
import com.models.Ingredient;
import services.RecipeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Η κύρια κλάση της εφαρμογής για το πρώτο μέρος.
 * Διαχειρίζεται την εκτέλεση μέσω της κονσόλας.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            // Εμφανίζει οδηγίες χρήσης εάν δεν δοθούν ορίσματα
            System.out.println("Χρήση:");
            System.out.println("Για εμφάνιση συνταγής: java -jar recipes.jar <recipe_file.cook>");
            System.out.println("Για λίστα αγορών: java -jar recipes.jar -list <recipe1.cook> <recipe2.cook> ...");
            return;
        }

        RecipeManager manager = new RecipeManager();

        // Έλεγχος για τη λειτουργία "λίστα αγορών"
        if (args[0].equals("-list")) {
            if (args.length < 2) {
                System.out.println("Παρακαλώ δώστε τουλάχιστον ένα αρχείο συνταγής για λίστα αγορών.");
                return;
            }
            generateShoppingList(manager, args);
        } else {
            // Λειτουργία εμφάνισης συνταγής
            displayRecipe(manager, args[0]);
        }
    }

    /**
     * Λειτουργία εμφάνισης συνταγής.
     *
     * @param manager Ο διαχειριστής συνταγών.
     * @param recipeFile Το αρχείο συνταγής.
     */
    private static void displayRecipe(RecipeManager manager, String recipeFile) {
        Recipe recipe = manager.loadRecipe(recipeFile);
        if (recipe == null) {
            System.out.println("Αποτυχία φόρτωσης της συνταγής από το αρχείο: " + recipeFile);
            return;
        }

        // Εμφάνιση των στοιχείων της συνταγής
        System.out.println("Συνταγή: " + recipe.getName());
        System.out.println("\nΥλικά:");
        for (Ingredient ingredient : recipe.getIngredients()) {
            System.out.println("- " + ingredient);
        }
        System.out.println("\nΣκεύη:");
        recipe.getUtensils().forEach(utensil -> System.out.println("- " + utensil));

        System.out.println("\nΣυνολικός Χρόνος:");
        int totalSeconds = recipe.getSteps().stream().mapToInt(step -> step.getTimeInSeconds()).sum();
        System.out.println(totalSeconds / 60 + " λεπτά");

        System.out.println("\nΒήματα:");
        int stepCounter = 1;
        for (var step : recipe.getSteps()) {
            System.out.println(stepCounter++ + ". " + step.getDescription());
        }
    }

    /**
     * Λειτουργία δημιουργίας λίστας αγορών.
     *
     * @param manager Ο διαχειριστής συνταγών.
     * @param args Τα ορίσματα (λίστα αρχείων συνταγών).
     */
    private static void generateShoppingList(RecipeManager manager, String[] args) {
        Map<String, Double> aggregatedIngredients = new HashMap<>();

        // Διαβάζει κάθε αρχείο συνταγής και συγκεντρώνει τα υλικά
        for (int i = 1; i < args.length; i++) {
            Recipe recipe = manager.loadRecipe(args[i]);
            if (recipe == null) {
                System.out.println("Αποτυχία φόρτωσης της συνταγής από το αρχείο: " + args[i]);
                continue;
            }

            // Προσθήκη των υλικών στη συγκεντρωτική λίστα
            for (Ingredient ingredient : recipe.getIngredients()) {
                aggregatedIngredients.merge(ingredient.getName(), ingredient.getQuantity(), Double::sum);
            }
        }

        // Εμφάνιση της λίστας αγορών
        System.out.println("\nΛίστα Αγορών:");
        aggregatedIngredients.forEach((name, quantity) -> System.out.println("- " + name + ": " + quantity));
    }
}