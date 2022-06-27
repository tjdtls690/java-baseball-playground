package com.jun_hyeok.baseball_game.input;

import com.jun_hyeok.baseball_game.domain.Ball;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static final int MAX_POSITION = 3;
    public static final int MIN_POSITION = 0;

    public List<Ball> getComBallBox() {
        List<Ball> comBallBox = new ArrayList<>();
        List<Integer> comNumBox = getComNumBox();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            int comNum = comNumBox.get(i);
            comBallBox.add(new Ball(i, comNum));
        }
        return comBallBox;
    }

    List<Integer> getComNumBox() {
        List<Integer> comNumBox = new ArrayList<>();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            int comNum = getDiffNum(comNumBox);
            comNumBox.add(comNum);
        }
        return comNumBox;
    }

    private int getDiffNum(List<Integer> comNumBox) {
        boolean checkDiffNum = false;
        int comNum = 0;
        while(!checkDiffNum){
            comNum = (int) (Math.random() * 9) + 1;
            checkDiffNum = isDiffNum(comNumBox, comNum);
        }
        return comNum;
    }

    private boolean isDiffNum(List<Integer> comNumBox, int comNum) {
        return !comNumBox.contains(comNum);
    }
}
