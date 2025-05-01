package com.tbpokemon;

import java.util.Map;

public class Pokedex {
    Map<String, Pokemon> pokedex;

    public Pokedex() {
        this.pokedex = null;
    }

    public Pokemon getPokemon(String pokemon) {
        return pokedex.get(pokemon);
    }
}
