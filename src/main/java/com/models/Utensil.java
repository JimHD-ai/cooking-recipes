package com.models;

/**
 * Αναπαριστά ένα σκεύος μαγειρικής που χρειάζεται σε μια συνταγή.
 */
public class Utensil {
    private String name; // Το όνομα του σκεύους

    /**
     * Κατασκευαστής για δημιουργία ενός αντικειμένου σκεύους.
     *
     * @param name Το όνομα του σκεύους.
     */
    public Utensil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}