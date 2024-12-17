package com.models;

/**
 * Αναπαριστά ένα υλικό που χρησιμοποιείται σε μια συνταγή.
 */
public class Ingredient {
    private String name; // Το όνομα του υλικού
    private double quantity; // Η ποσότητα του υλικού
    private String unit; // Η μονάδα μέτρησης (π.χ., γραμμάρια, ml)

    /**
     * Κατασκευαστής για δημιουργία ενός αντικειμένου υλικού.
     *
     * @param name Το όνομα του υλικού.
     * @param quantity Η ποσότητα του υλικού.
     * @param unit Η μονάδα μέτρησης.
     */
    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return name + " " + quantity + " " + unit;
    }
}