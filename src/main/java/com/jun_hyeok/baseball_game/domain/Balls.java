package com.jun_hyeok.baseball_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> comBallBox;

    public Balls(List<Integer> comNumBox) {
        this.comBallBox = mapBall(comNumBox);
    }

    private List<Ball> mapBall(List<Integer> comNumBox) {
        List<Ball> mappingBallBox = new ArrayList<>();
        for (int i = 0; i <3; i++) {
            mappingBallBox.add(new Ball(i, comNumBox.get(i)));
        }
        return mappingBallBox;
    }

    public BallStatus play(Ball playerBall) {
        return comBallBox.stream()
                .map(comBall -> comBall.play(playerBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
