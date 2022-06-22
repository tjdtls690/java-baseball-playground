package com.jun_hyeok.baseball_game.domain;

import java.util.Objects;

public class BallNumber {
    private int number;

    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 1;


    public BallNumber(int number) throws IllegalArgumentException{
        if(number > MAX_NUM || number < MIN_NUM){
            throw new IllegalArgumentException("숫자는 1 ~ 9 까지만 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
