package com.tbpokemon;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class MoveEffectiveness {
    public enum Effective {
        NO_EFFECT,
        NOT_EFFECTIVE,
        EFFECTIVE,
        SUPER_EFFECTIVE;
    }

    private static MoveEffectiveness instance;
    private EffectChart effectChart;

    class EffectChart {
        Map<Type, Map<Type, Effective>> chart;

        private EffectChart() {
            chart = new HashMap<>();
        }
    }


    private MoveEffectiveness() {
        String effectPath = "tbpokemon\\src\\main\\resources\\TypeEffectiveness.json";
        try {
            JsonReader reader = new JsonReader(new FileReader(effectPath));
            Gson gson = new Gson();
            effectChart = gson.fromJson(reader, EffectChart.class);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MoveEffectiveness getInstance() {
        if (instance == null) {
            return new MoveEffectiveness();
        }
        return instance;
    }

    public float checkEffective(Move attack, Pokemon target) {
        float damageMulti = 1f;
        Effective typeEffect = effectChart.chart.get(attack.getType()).get(target.getType());
        Effective subtypeEffect = Effective.EFFECTIVE;
        if (target.getSubtype() != Type.NONE) {
            subtypeEffect = effectChart.chart.get(attack.getType()).get(target.getSubtype());
        }

        for(Effective effect : Arrays.asList(typeEffect, subtypeEffect)) {
            switch (effect) {
                case NO_EFFECT:
                    return 0f;
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
        for(Map.Entry<Type, Map<Type, Effective>> attack : effectChart.chart.entrySet()) {
            System.out.printf("\nAttack Type: %s\n", attack.getKey().name());
            for(Map.Entry<Type, Effective> target : attack.getValue().entrySet()) {
                System.out.printf("Target Type: %s Effect: %s\n", target.getKey(), target.getValue());
            }
        }
    }
}
