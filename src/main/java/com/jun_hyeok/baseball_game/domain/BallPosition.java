package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class BallPosition {
    public static final String ERROR_MESSAGE = "위치는 0 ~ 2 만 가능합니다..";
    private final int position;

    public BallPosition(int position) {
        if (position < 0 || position > 2) {
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
