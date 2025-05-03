package com.tbpokemon;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    String name;
    Type type;
    Type subtype;
    int level;
    Map<String, Integer> stats;
    Map<String, Move> moves;

    public Pokemon() {
        this.name = "Squirtle";
        this.type = Type.WATER;
        this.subtype = Type.NONE;
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

    public Type getSubtype() {
        return subtype;
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
        float damage = ((2 * level * getCrit())/5f) + 2;
        damage *= move.getPower();
        if (move.getCategory() == Category.PHYSICAL) {
            damage *= ((float)getAtk() / (float)target.getDef());
        } else {
            damage *= ((float)getSpAtk() / (float)target.getSpDef());
        }
        damage = (damage / 50f) + 2;
        damage *= getSameTypeBonus(move);
        damage *= MoveEffectiveness.getInstance().checkEffective(move, target);
        if (damage == 0f) {
            return 0;
        }
        damage = damage * getRandomness();
        return Math.max(1, (int)damage);
    }

    private float getSameTypeBonus(Move move) {
        if (move.getType() == type || move.getType() == subtype) {
            return 1.5f;
        }
        return 1f;
    }

    // 1/16 chance
    private float getCrit() {
        int num = (int)(Math.random() * 16) + 1;
        if (num == 1) {
            System.out.println("CRIT!!!");
            return 2f;
        }
        return 1f;
    }

    private float getRandomness() {
        float num = (float)(217 + (int)(Math.random() * ((255 - 217) + 1))) / 255;
        return num;
    }
}
