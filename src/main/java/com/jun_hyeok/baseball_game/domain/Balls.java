package com.jun_hyeok.baseball_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 3;
    private final List<Ball> comBallBox;

    public Balls(List<Integer> comNumBox) {
        List<Ball> comBallBox = new ArrayList<>();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            comBallBox.add(new Ball(i, comNumBox.get(i)));
        }

        this.comBallBox = comBallBox;
    }

    public Judgment play(List<Ball> playerBallBox){
        Judgment resultAssistant = new Judgment();
        for (int i = 0; i < 3; i++) {
            BallStatus status = this.play(playerBallBox.get(i));
            resultAssistant.report(status);
        }
        return resultAssistant;
    }

    private List<Ball> getPlayerBallBox(List<Integer> playerNumBox) {
        List<Ball> playerBallBox = new ArrayList<>();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            playerBallBox.add(new Ball(i, playerNumBox.get(i)));
        }
        return playerBallBox;
    }

    public BallStatus play(Ball playerBall) {
        if(this.isMatch(playerBall).isStrike()){
            return BallStatus.STRIKE;
        }

        if(this.isMatch(playerBall).isBall()){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private BallStatus isMatch(Ball playerBall) {
        return comBallBox.stream()
                .map(ball -> ball.play(playerBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

}
