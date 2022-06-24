package com.jun_hyeok.baseball_game.input;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 3;

    public List<Integer> getRanNum() {
        List<Integer> comNumBox = new ArrayList<>();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            int num = getDiffNum(comNumBox);
            comNumBox.add(num);
        }

        return comNumBox;
    }

    private int getDiffNum(List<Integer> comNumBox) {
        boolean checkDiff = false;
        int num = 0;
        while (!checkDiff) {
            num = (int) (Math.random() * 9) + 1;
            checkDiff = !comNumBox.contains(num);
        }
        return num;
    }
}
