package com.jun_hyeok.baseball_game.domain;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
