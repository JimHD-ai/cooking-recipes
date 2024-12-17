package com.models;

import java.util.List;

/**
 * Αναπαριστά μια συνταγή, συμπεριλαμβανομένων του ονόματος, των υλικών, των σκευών και των βημάτων.
 */
public class Recipe {
    private String name; // Το όνομα της συνταγής
    private List<Ingredient> ingredients; // Λίστα των υλικών της συνταγής
    private List<Utensil> utensils; // Λίστα των σκευών που απαιτούνται
    private List<Step> steps; // Λίστα των βημάτων προετοιμασίας

    /**
     * Κατασκευαστής για δημιουργία μιας συνταγής.
     *
     * @param name Το όνομα της συνταγής.
     * @param ingredients Η λίστα των υλικών.
     * @param utensils Η λίστα των σκευών.
     * @param steps Η λίστα των βημάτων.
     */
    public Recipe(String name, List<Ingredient> ingredients, List<Utensil> utensils, List<Step> steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.utensils = utensils;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Utensil> getUtensils() {
        return utensils;
    }

    public void setUtensils(List<Utensil> utensils) {
        this.utensils = utensils;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Recipe{name='" + name + "', ingredients=" + ingredients + ", utensils=" + utensils + ", steps=" + steps + "}";
    }
}