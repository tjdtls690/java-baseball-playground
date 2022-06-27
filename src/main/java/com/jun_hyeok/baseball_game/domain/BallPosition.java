package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class BallPosition {
    public static final String ERROR_MESSAGE = "사용해야할 볼의 갯수는 3개입니다.";
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 2;
    private final int position;

    public BallPosition(int position) {
        if(position < MIN_POSITION || position > MAX_POSITION){
            throw new IllegalArgumentException(ERROR_MESSAGE);
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
