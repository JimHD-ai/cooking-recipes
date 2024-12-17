package com.recipes.models;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private List<Utensil> utensils;
    private List<Step> steps;

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
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", utensils=" + utensils +
                ", steps=" + steps +
                '}';
    }
}