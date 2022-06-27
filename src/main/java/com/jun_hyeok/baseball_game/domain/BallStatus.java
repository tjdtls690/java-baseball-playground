package com.jun_hyeok.baseball_game.domain;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
