package com.jun_hyeok.baseball_game.input;

import com.jun_hyeok.baseball_game.domain.Judgment;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> getComNumber(){
        ArrayList<Integer> comNumBox = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = getDiffNum(comNumBox, 0);
            comNumBox.add(num);
        }
        return comNumBox;
    }

    private int getDiffNum(List<Integer> comNumBox, int num){
        Judgment judgment = new Judgment();
        boolean isDiff = true;
        while(isDiff){
            num = createRandomNumber();
            isDiff = judgment.isDifferent(comNumBox, num);
        }
        return num;
    }

    private int createRandomNumber(){
        return (int) (Math.random() * 9) + 1;
    }
}
