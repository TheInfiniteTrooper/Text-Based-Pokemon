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
        System.out.println("Goodbye!");
    }

    /*
     * Choose your pokemon:
     * 1) 2) 3)
     * 
     * You venture into the tall grass
     * A wild Squirtle has appeared!
     * Wild Squirtle
     * LVL: 10 HP: 50 / 50
     * 
     * Go Bulbasaur!
     * 
     * Bulbasaur 
     * LVL: 10 HP: 50 / 50
     * What will Bulbasaur do?
     * 1) 2) 3) 4)
     * 
     * Bulbasaur used Razor Leaf
     * It was super effective!
     * It dealt 12 Damage!
     * 
     * Wild Squirtle
     * LVL: 10 HP: 38 / 50
     * The Wild Squirtle used Water Gun
     * It dealt 8 Damage!
     * 
     * Bulbasaur 
     * LVL: 10 HP: 42 / 50
     * What will Bulbasaur do?
     * 1) 2) 3) 4)
     * 
     * The Wild Squirtle fainted!
     * 
     * or
     * 
     * Bulbasaur has fainted!
     * 
     * Would you like to battle again?
     * 1) 2)
     * 
     * You venture into the tall grass
     * A wild Charmander has appeared!
     * 
     * or
     * 
     * You return home
     * Thanks for playing!
     */
}
