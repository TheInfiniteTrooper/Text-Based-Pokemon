import java.util.Scanner;

public class GameController {

    Scanner scanner;
    Pokemon enemyPokemon;
    Pokemon playerPokemon;
    boolean reset;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public void setEnemyPokemon(Pokemon pokemon) {
        this.enemyPokemon = pokemon;
    }

    public void setPlayerPokemon(Pokemon pokemon) {
        this.playerPokemon = pokemon;
    }

    public boolean battle() {
        choosePokemon();
        spawnWildPokemon();

        System.out.printf("The wild %s has fainted!\n", this.enemyPokemon.getName());

        playAgain();
        if (this.reset) {
            return this.reset;
        }
        this.scanner.close();
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

    private void choosePokemon() {
        Integer opt;
        while (true) {
            System.out.println("Choose your Pokemon:\n1) 2) 3)");
            try {
                opt = getOption();
                this.playerPokemon = pokemonSelector(opt);
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
                return new Pokemon();
            case 2:
                return new Pokemon();
            case 3:
                return new Pokemon();
            default:
                throw new IllegalArgumentException("Option should be 1, 2, or 3!");
        }
    }

    private void spawnWildPokemon() {
        int num = (int)(Math.random() * 3) + 1;
        this.enemyPokemon = pokemonSelector(num);
        System.out.println("You venture into the tall grass.");
        System.out.printf("A wild %s has appeared!\n", this.enemyPokemon.getName());
    }

    private Integer getOption() {
        try {
            return Integer.parseInt(this.scanner.nextLine());
        } catch (Exception e) {
            System.err.printf("ERROR: %s Please select a valid option!\n", e.getMessage());
            return null;
        }
    }
}