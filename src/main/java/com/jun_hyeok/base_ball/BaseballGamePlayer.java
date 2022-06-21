package com.jun_hyeok.base_ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseballGamePlayer {

    private final BufferedReader br;
    final int[] inputNumBox;

    BaseballGamePlayer () {
        br = new BufferedReader(new InputStreamReader((System.in)));
        inputNumBox = new int[BaseballGameCom.baseballCount];
    }

    boolean saveNum (int num) {
        inputNumBox[0] = num / 100;
        inputNumBox[1] = num % 100 / 10;
        inputNumBox[2] = num % 10;
        return inputNumCheck(num);
    }

    private boolean inputNumCheck (int num) {
        if(inputNumBox[0] <= 0 || inputNumBox[1] <= 0 || inputNumBox[2] <= 0
                || inputNumBox[0] > 10 || num == -1){
            return false;
        }

        return inputNumBox[0] != inputNumBox[1] && inputNumBox[0] != inputNumBox[2] && inputNumBox[1] != inputNumBox[2];
    }
}
