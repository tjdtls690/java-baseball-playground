package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class Ball {
    private final BallPosition position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = new BallPosition(position);
        this.number = new BallNumber(number);
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }

        if(number.equals(ball.number)){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position.equals(ball.position) && number.equals(ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
