package com.recipes.models;

public class Step {
    private String description;
    private int timeInSeconds;

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
        return "Step{" +
                "description='" + description + '\'' +
                ", timeInSeconds=" + timeInSeconds +
                '}';
    }
}