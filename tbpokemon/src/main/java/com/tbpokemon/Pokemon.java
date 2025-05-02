package com.tbpokemon;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    String name;
    Type type;
    int level;
    Map<String, Integer> stats;
    Map<String, Move> moves;

    public Pokemon() {
        this.name = "Squirtle";
        this.type = Type.WATER;
        this.level = 10;
        this.moves = new HashMap<>();
        this.stats = new HashMap<>();
        this.stats.put("HP", 44);
        this.stats.put("ATK", 48);
        this.stats.put("DEF", 65);
        this.stats.put("SPATK", 50);
        this.stats.put("SPDEF", 64);
        this.stats.put("SPD", 43);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return stats.get("HP").intValue();
    }

    public int getAtk() {
        return stats.get("ATK").intValue();
    }

    public int getDef() {
        return stats.get("DEF").intValue();
    }

    public int getSpAtk() {
        return stats.get("SPATK").intValue();
    }

    public int getSpDef() {
        return stats.get("SPDEF").intValue();
    }

    public int getSpeed() {
        return stats.get("SPD").intValue();
    }

    public void printAllInfo() {
        System.out.println("\n" + name);
        System.out.printf("LVL: %d\n", level);
        System.out.printf("HP: %d / %d\n", getHP(), getHP());
        System.out.printf("Type: %s\n", getType().name());
        System.out.printf("ATK: %d\n", getAtk());
        System.out.printf("DEF: %d\n", getDef());
        System.out.printf("SPATK: %d\n", getSpAtk());
        System.out.printf("SPDEF: %d\n", getSpDef());
        System.out.printf("SPD: %d\n", getSpeed());
        for(Map.Entry<String, Move> entry : moves.entrySet()) {
            entry.getValue().printInfo();
        }
    }

    public void printInfo() {
        System.out.println("\n" + name);
        System.out.printf("LVL: %d\n", level);
        System.out.printf("HP: %d / %d\n", getHP(), getHP());
    }

    public Move getMove(String move) {
        return moves.get(move);
    }

    public int useMove(Move move, Pokemon target) {
        // x = (((2*lvl*crit)/5) + 2) * power * (getAtk()/target.getDef()) / 50
        // (x + 2) * STAB * target.Type1 * target.Type2 * random
        return 0;
    }
}
