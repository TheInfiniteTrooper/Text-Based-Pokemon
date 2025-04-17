import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    String name;
    Type type;
    int level;
    Map<String, Integer> stats;

    public Pokemon() {
        this.name = "Squirtle";
        this.type = Type.WATER;
        this.level = 10;
        this.stats = new HashMap<>();
        this.stats.put("HP", 44);
        this.stats.put("ATK", 48);
        this.stats.put("DEF", 65);
        this.stats.put("SPATK", 50);
        this.stats.put("SPDEF", 64);
        this.stats.put("SPD", 43);
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHP() {
        return this.stats.get("HP").intValue();
    }

    public int getAtk() {
        return this.stats.get("ATK").intValue();
    }

    public int getDef() {
        return this.stats.get("DEF").intValue();
    }

    public int getSpAtk() {
        return this.stats.get("SPATK").intValue();
    }

    public int getSpDef() {
        return this.stats.get("SPDEF").intValue();
    }

    public int getSpeed() {
        return this.stats.get("SPD").intValue();
    }
}
