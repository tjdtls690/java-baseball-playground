package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public BallStatus play(Ball playerBall) {
        if(this.equals(playerBall)){
            return BallStatus.STRIKE;
        }

        if(this.matchBall(playerBall)){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBall(Ball playerBall) {
        return this.number == playerBall.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
