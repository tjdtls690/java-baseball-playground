package com.jun_hyeok.base_ball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaseballGameMain {

    private BaseballGameCom bc;
    private BaseballGamePlayer bp;

    public BaseballGameMain() {
        bc = new BaseballGameCom();
        bp = new BaseballGamePlayer();
    }

    private boolean runBaseballGame(int[] comNumBox) {

        return false;
    }

    private void execute() {
        InputView.startMessagePrint();
        boolean play = true;
        while(play){
            int[] comNumBox = bc.getRanNumBox();
            play = runBaseballGame(comNumBox);
        }
    }

    public static void main(String[] args) {
        BaseballGameMain main = new BaseballGameMain();
        main.execute();
    }
}
