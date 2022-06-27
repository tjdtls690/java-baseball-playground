package com.jun_hyeok.baseball_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 3;
    private final List<Ball> comBallBox;

    public Balls(List<Integer> comNumBox) {
        this.comBallBox = mapBall(comNumBox);
    }

    private List<Ball> mapBall(List<Integer> comNumBox) {
        List<Ball> mappingBallBox = new ArrayList<>();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
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

    public Referee play(List<Ball> playerBallBox){
        Referee referee = new Referee();
        for (Ball playerBall : playerBallBox) {
            referee.ballMatch(this.play(playerBall));
        }
        return referee;
    }
}
