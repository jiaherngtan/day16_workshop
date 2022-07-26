package com.vttp2022.workshop16.model;

public class Pieces {
    private RuleBook rulebook;
    private Board board;
    private Discs discs;

    public RuleBook getRulebook() {
        return rulebook;
    }

    public void setRulebook(RuleBook rulebook) {
        this.rulebook = rulebook;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Discs getDiscs() {
        return discs;
    }

    public void setDiscs(Discs discs) {
        this.discs = discs;
    }
}
