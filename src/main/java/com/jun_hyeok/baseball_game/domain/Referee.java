package com.jun_hyeok.baseball_game.domain;

public class Referee {
    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if(status.isStrike()){
            this.strike++;
        }

        if(status.isBall()){
            this.ball++;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
