package com.tbpokemon;

import java.util.HashMap;
import java.util.Map;

public class MoveEffectiveness {
    public enum Effective {
        NO_EFFECT,
        NOT_EFFECTIVE,
        EFFECTIVE,
        SUPER_EFFECTIVE;
    }

    Map<Type, Map<Type, Effective>> chart;

    public MoveEffectiveness() {
        this.chart = new HashMap<>();
    }

    public float checkEffective(Move attack, Pokemon target) {
        Effective effectiveness = chart.get(attack.getType()).get(target.getType());
        switch (effectiveness) {
            case NO_EFFECT:
                return 0f;
            case NOT_EFFECTIVE:
                return 0.5f;
            case EFFECTIVE:
                return 1f;
            case SUPER_EFFECTIVE:
                return 2f;
            default:
                return 1f;
        }
    }

    public void printChart() {
        for(Map.Entry<Type, Map<Type, Effective>> attack : chart.entrySet()) {
            System.out.printf("\nAttack Type: %s\n", attack.getKey().name());
            for(Map.Entry<Type, Effective> target : attack.getValue().entrySet()) {
                System.out.printf("Target Type: %s Effect: %s\n", target.getKey(), target.getValue());
            }
        }
    }
}
