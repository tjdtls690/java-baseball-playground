package com.jun_hyeok.baseball_game.domain;

import java.util.List;

public class Judgment {

    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 1;

    public boolean isDifferent(List<Integer> currentList, int num) {
        return !currentList.contains(num);
    }

    public boolean isInRange(int num) {
        return num <= MAX_NUM && num >= MIN_NUM;
    }
}
