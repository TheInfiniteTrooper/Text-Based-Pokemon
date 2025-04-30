package com.tbpokemon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Battle Start!");
        GameController gameController = new GameController();
        while(true) {
            boolean playAgain = gameController.battle();
            if (!playAgain) {
                break;
            }
        }
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
