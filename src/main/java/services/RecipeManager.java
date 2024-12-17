package services;

import com.models.Ingredient;
import com.models.Recipe;
import com.models.Step;
import com.models.Utensil;

import java.io.*;
import java.util.*;

/**
 * Υλοποιεί τη διαχείριση συνταγών, όπως τη φόρτωση από αρχεία και τη δημιουργία λιστών αγορών.
 */
public class RecipeManager {

    /**
     * Φορτώνει μια συνταγή από ένα αρχείο και επιστρέφει ένα αντικείμενο Recipe.
     *
     * @param filePath Η διαδρομή του αρχείου συνταγής.
     * @return Ένα αντικείμενο Recipe με τα δεδομένα της συνταγής.
     */
    public Recipe loadRecipe(String filePath) {
        String name = null;
        List<Ingredient> ingredients = new ArrayList<>();
        List<Utensil> utensils = new ArrayList<>();
        List<Step> steps = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Name:")) {
                    name = line.substring(5).trim();
                } else if (line.startsWith("@")) {
                    parseIngredient(line, ingredients);
                } else if (line.startsWith("#")) {
                    utensils.add(new Utensil(line.substring(1).trim()));
                } else if (line.startsWith("~")) {
                    steps.add(parseStep(line));
                } else {
                    steps.add(new Step(line, 0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Recipe(name, ingredients, utensils, steps);
    }

    /**
     * Αναλύει μια γραμμή που περιγράφει ένα υλικό και την προσθέτει στη λίστα υλικών.
     *
     * @param line Η γραμμή που περιέχει το υλικό.
     * @param ingredients Η λίστα των υλικών που θα ενημερωθεί.
     */
    private void parseIngredient(String line, List<Ingredient> ingredients) {
        String[] parts = line.substring(1).split("\\{");
        String name = parts[0].trim();
        String[] quantityAndUnit = parts[1].replace("}", "").split("%");
        double quantity = Double.parseDouble(quantityAndUnit[0]);
        String unit = quantityAndUnit.length > 1 ? quantityAndUnit[1].trim() : "";
        ingredients.add(new Ingredient(name, quantity, unit));
    }

    /**
     * Αναλύει μια γραμμή που περιγράφει ένα βήμα με χρόνο και επιστρέφει ένα αντικείμενο Step.
     *
     * @param line Η γραμμή που περιέχει το βήμα.
     * @return Ένα αντικείμενο Step με τα δεδομένα του βήματος.
     */
    private Step parseStep(String line) {
        String[] parts = line.substring(1).split("%");
        int timeInSeconds = Integer.parseInt(parts[0]) * 60; // Μετατροπή λεπτών σε δευτερόλεπτα
        return new Step(parts[1].trim(), timeInSeconds);
    }
}