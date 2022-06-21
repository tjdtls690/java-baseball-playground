package com.jun_hyeok.base_ball;

public class BaseBallGameUtility {


    static boolean compare(int[] playerNum, int[] comNum){
        int st = getSt(playerNum, comNum);
        int ball = getBall(playerNum, comNum);

        ResultView.resultPrint(st, ball);
        return st == 3;
    }

    private static int getBall(int[] playerNum, int[] comNum) {
        int ball = 0;
        for(int i = 0; i < playerNum.length; i++){
            ball += checkBall(comNum, playerNum[i], i);
        }

        return ball;
    }

    private static int checkBall(int[] comNum, int playerNum, int idx) {
        int after = (idx + 1) % 3;
        int before = (idx + 2) % 3;

        if(playerNum == comNum[before] || playerNum == comNum[after]){
            return 1;
        }
        return 0;
    }

    private static int getSt(int[] playerNum, int[] comNum) {
        int st = 0;
        for(int i = 0; i < playerNum.length; i++){
            st += checkSt(playerNum[i], comNum[i]);
        }

        return st;
    }

    private static int checkSt(int playerNum, int comNum) {
        if (playerNum == comNum) {
            return 1;
        }
        return 0;
    }
}
