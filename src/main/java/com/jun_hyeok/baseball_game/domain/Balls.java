package com.jun_hyeok.baseball_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> comBallBox;

    public Balls(List<Integer> comNumBox) {
        this.comBallBox = mappingBall(comNumBox);
    }

    private List<Ball> mappingBall(List<Integer> numBox) {
        List<Ball> mappingBallBox = new ArrayList<>();
        for (int i = BallPosition.MIN_POSITION; i <= BallPosition.MAX_POSITION; i++) {
            mappingBallBox.add(new Ball(i, numBox.get(i)));
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

    public Referee play(List<Ball> playerBallBox) {
        Referee referee = new Referee();
        for (Ball playerBall : playerBallBox) {
            referee.ballMatch(this.play(playerBall));
        }
        return referee;
    }
}
