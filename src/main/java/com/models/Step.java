package com.models;

/**
 * Αναπαριστά ένα βήμα στην προετοιμασία μιας συνταγής.
 */
public class Step {
    private String description; // Περιγραφή του βήματος
    private int timeInSeconds; // Χρόνος που απαιτείται για το βήμα, σε δευτερόλεπτα

    /**
     * Κατασκευαστής για δημιουργία ενός αντικειμένου βήματος.
     *
     * @param description Η περιγραφή του βήματος.
     * @param timeInSeconds Ο χρόνος που απαιτείται για το βήμα.
     */
    public Step(String description, int timeInSeconds) {
        this.description = description;
        this.timeInSeconds = timeInSeconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public String toString() {
        return description + " (" + timeInSeconds + " δευτερόλεπτα)";
    }
}
