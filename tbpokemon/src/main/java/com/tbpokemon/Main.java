package com.tbpokemon;

import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String pokedexPath = "tbpokemon\\src\\main\\resources\\Pokemon.json";
        String moveListPath = "tbpokemon\\src\\main\\resources\\Moves.json";

        System.out.println("\nBattle Start!");
        GameController gameController = new GameController(pokedexPath, moveListPath);
        while(true) {
            boolean playAgain = gameController.battle();
            if (!playAgain) {
                break;
            }
        }
        scanner.close();
        System.out.println("You return home\nThanks for Playing!");
    }
}
