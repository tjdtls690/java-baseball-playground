package com.jun_hyeok.baseball_game.domain;

public class Referee {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void ballMatch(BallStatus result) {
        if(result.isStrike()){
            strike++;
        }

        if(result.isBall()){
            ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}
