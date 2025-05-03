package com.tbpokemon;

import java.util.Arrays;
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
        float damageMulti = 1f;
        Effective typeEffect = chart.get(attack.getType()).get(target.getType());
        Effective subtypeEffect = Effective.EFFECTIVE;
        if (target.getSubtype() != Type.NONE) {
            subtypeEffect = chart.get(attack.getType()).get(target.getSubtype());
        }

        for(Effective effect : Arrays.asList(typeEffect, subtypeEffect)) {
            switch (effect) {
                case NO_EFFECT:
                    damageMulti *= 0f;
                    break;
                case NOT_EFFECTIVE:
                    damageMulti *= 0.5f;
                    break;
                case EFFECTIVE:
                    damageMulti *= 1f;
                    break;
                case SUPER_EFFECTIVE:
                    damageMulti *= 2f;
                    break;
                default:
                    damageMulti *= 1f;
                    break;
            }
        }
        
        return damageMulti;
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
