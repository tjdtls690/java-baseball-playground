package com.jun_hyeok.baseball_game.domain;

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
}
