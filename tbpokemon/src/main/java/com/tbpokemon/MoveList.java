package com.tbpokemon;

import java.util.Map;

public class MoveList {
    Map<String, Move> moveList;

    public MoveList() {
        this.moveList = null;
    }

    public Move getMove(String move) {
        return moveList.get(move);
    }

    public Map<String, Move> getMoveList() {
        return moveList;
    }
}
