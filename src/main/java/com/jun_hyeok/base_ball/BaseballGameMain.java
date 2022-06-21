package com.jun_hyeok.base_ball;

import java.util.Arrays;

public class BaseballGameMain {

    private final BaseballGameCom bc;
    private final InputView iv;

    public BaseballGameMain() {
        bc = new BaseballGameCom();
        iv = new InputView();
    }

    private boolean runBaseballGame(int[] comNumBox) {
        boolean checkAnswer = false;
        while(!checkAnswer) {
            int[] playerNumBox = iv.getPlayerNumBox();
            checkAnswer = BaseBallGameUtility.compare(playerNumBox, comNumBox);
        }
        System.out.println("comNum : " + Arrays.toString(comNumBox));
        ResultView.successPrint();

        return iv.restartMessageAndSelect();
    }

    private void execute() {
        iv.startMessagePrint();
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
