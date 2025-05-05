package com.tbpokemon;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class GameController {
    Pokedex pokedex;
    MoveEffectiveness effectivenessChart;
    MoveList moveList;
    Pokemon enemyPokemon;
    Pokemon playerPokemon;
    boolean reset;

    public GameController(String pokedexPath, String moveListPath) {
        try {
            JsonReader reader = new JsonReader(new FileReader(pokedexPath));
            Gson gson = new Gson();
            this.pokedex = gson.fromJson(reader, Pokedex.class);
            reader.close();
            reader = new JsonReader(new FileReader(moveListPath));
            this.moveList = gson.fromJson(reader, MoveList.class);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        effectivenessChart = MoveEffectiveness.getInstance();
    }

    public void setEnemyPokemon(Pokemon pokemon) {
        this.enemyPokemon = pokemon;
    }

    public void setPlayerPokemon(Pokemon pokemon) {
        this.playerPokemon = pokemon;
    }

    public boolean battle() {
        choosePokemon();
        playerPokemon.printInfo(false);
        spawnWildPokemon();
        enemyPokemon.printInfo(true);
        System.out.printf("Go %s!\n\n", playerPokemon.getName());
        moveSelect();
        enemyPokemon.printInfo(true);
        enemyAttack();
        playerPokemon.printInfo(false);

        System.out.printf("The wild %s has fainted!\n", this.enemyPokemon.getName());

        playAgain();
        if (this.reset) {
            return this.reset;
        }
        return this.reset;
    }

    private void playAgain() {
        Integer opt;
        while (true) {
            System.out.println("Would you like to play again?\n1) Yes 2) No");
            try {
                opt = getOption();
                this.reset = playAgainSelector(opt);
                break;
            } catch (IllegalArgumentException e) {
                System.err.printf("ERROR: %s\n", e.getMessage());
            }
        }
    }

    private boolean playAgainSelector(Integer opt) {
        if (opt == null) {
            throw new IllegalArgumentException("Option should be 1 or 2!");
        }
        switch (opt) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                throw new IllegalArgumentException("Option should be 1 or 2!");
        }
    }
    
    private void moveSelect() {
        Integer opt;
        Move move;
        while (true) {
            System.out.printf("What will %s do?\n", playerPokemon.getName());
            System.out.printf("1) %s 2) %s 3) %s 4) %s\n", playerPokemon.getMove(1).getName(), 
                playerPokemon.getMove(2).getName(), playerPokemon.getMove(3).getName(), playerPokemon.getMove(4).getName());
            try {
                opt = getOption();
                move = moveSelector(playerPokemon, opt);
                break;
            } catch (IllegalArgumentException e) {
                System.err.printf("ERROR: %s\n", e.getMessage());
            }
        }
        int dmg = playerPokemon.useMove(move, enemyPokemon);
        System.out.printf("It did %d damage!\n", dmg);
        enemyPokemon.takeDamage(dmg);
    }

    private Move moveSelector(Pokemon pokemon, Integer opt) {
        if (opt == null) {
            throw new IllegalArgumentException("Option should be 1, 2, 3, or 4!");
        }
        switch (opt) {
            case 1, 2, 3, 4:
                return pokemon.getMove(opt);
            default:
                throw new IllegalArgumentException("Option should be 1, 2, 3, or 4!");
        }
    }

    private void enemyAttack() {
        int num = (int)(Math.random() * 4) + 1;
        Move move = moveSelector(enemyPokemon, num);
        System.out.print("The wild ");
        int dmg = enemyPokemon.useMove(move, playerPokemon);
        System.out.printf("It did %d damage!\n", dmg);
        playerPokemon.takeDamage(dmg);
    }

    private void choosePokemon() {
        Integer opt;
        while (true) {
            System.out.println("Choose your Pokemon:\n1) Squirtle 2) Bulbasaur 3) Charmander");
            try {
                opt = getOption();
                this.playerPokemon = pokemonSelector(opt);
                this.playerPokemon.resetHP();
                break;
            } catch (IllegalArgumentException e) {
                System.err.printf("ERROR: %s\n", e.getMessage());
            }
        }
        System.out.printf("You chose %s.\n", this.playerPokemon.getName());
    }
    
    private Pokemon pokemonSelector(Integer opt) {
        if (opt == null) {
            throw new IllegalArgumentException("Option should be 1, 2, or 3!");
        }
        switch (opt) {
            case 1:
                return pokedex.getPokemon("squirtle");
            case 2:
                return pokedex.getPokemon("bulbasaur");
            case 3:
                return pokedex.getPokemon("charmander");
            default:
                throw new IllegalArgumentException("Option should be 1, 2, or 3!");
        }
    }

    private void spawnWildPokemon() {
        int num = (int)(Math.random() * 3) + 1;
        this.enemyPokemon = pokemonSelector(num);
        this.enemyPokemon.resetHP();
        System.out.println("You venture into the tall grass.");
        System.out.printf("A wild %s has appeared!\n", this.enemyPokemon.getName());
    }

    private Integer getOption() {
        try {
            return Integer.parseInt(Main.scanner.nextLine());
        } catch (Exception e) {
            System.err.printf("ERROR: %s Please select a valid option!\n", e.getMessage());
            return null;
        }
    }
}