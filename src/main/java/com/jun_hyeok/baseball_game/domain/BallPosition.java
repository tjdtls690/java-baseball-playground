package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class BallPosition {
    public static final int MAX_IDX = 2;
    private final int position;

    public BallPosition(int position) {
        if(position > MAX_IDX){
            throw new IllegalArgumentException("볼의 갯수는 3개까지만 가능합니다.");
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
