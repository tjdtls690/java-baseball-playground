package com.jun_hyeok.baseball_game.domain;

public class Judgment {
    private int strike;
    private int ball;

    public void report(BallStatus status) {
        if(status == BallStatus.STRIKE){
            strike++;
        }

        if(status == BallStatus.BALL){
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }


    public boolean isGameEnd() {
        return strike == 3;
    }
}
