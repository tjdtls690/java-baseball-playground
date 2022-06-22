package com.jun_hyeok.baseball_game.domain;

import java.util.List;

public class Balls {
    private final List<Integer> comNumberBox;

    public Balls(List<Integer> comNumberBox) {
        this.comNumberBox = comNumberBox;
    }

    public BallStatus isMatchUp(Ball playerBall) {
        return BallStatus.NOTHING;
    }
}
