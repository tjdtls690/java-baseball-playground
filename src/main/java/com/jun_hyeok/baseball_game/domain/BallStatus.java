package com.jun_hyeok.baseball_game.domain;

import java.util.function.Predicate;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
