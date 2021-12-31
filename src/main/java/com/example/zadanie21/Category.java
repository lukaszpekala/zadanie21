package com.example.zadanie21;

public enum Category {
    FOOD("artykuły spożywcze"),
    HOME("artykuły gospodarstwa domowego"),
    OTHER("artykuły inne");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
