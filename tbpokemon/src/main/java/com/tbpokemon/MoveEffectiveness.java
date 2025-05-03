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

    public void printChart() {
        for(Map.Entry<Type, Map<Type, Effective>> attack : chart.entrySet()) {
            System.out.printf("\nAttack Type: %s\n", attack.getKey().name());
            for(Map.Entry<Type, Effective> target : attack.getValue().entrySet()) {
                System.out.printf("Target Type: %s Effect: %s\n", target.getKey(), target.getValue());
            }
        }
    }
}
