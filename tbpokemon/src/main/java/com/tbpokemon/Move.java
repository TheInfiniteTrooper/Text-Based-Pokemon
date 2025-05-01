package com.tbpokemon;

public class Move {
    String name;
    Type type;
    Category category;
    int power;
    int accuracy;
    int PP;

    public Move() {
        this.name = "Vine Whip";
        this.type = Type.GRASS;
        this.category = Category.PHYSICAL;
        this.power = 35;
        this.accuracy = 100;
        this.PP = 15;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public Category getCategory() {
        return this.category;
    }

    public int getPower() {
        return this.power;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public int getPP() {
        return this.PP;
    }

    public void printInfo() {
        System.out.printf("\nMove: %s\n", name);
        System.out.printf("Type: %s\n", type.name());
        System.out.printf("Category: %s\n", category.name());
        System.out.printf("Power: %d\n", power);
        System.out.printf("Accuracy: %d\n", accuracy);
        System.out.printf("PP %d / %d\n", PP, PP);
    }
}
