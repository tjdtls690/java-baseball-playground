package com.jun_hyeok.base_ball;

public class ResultView {
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    static void successPrint(){
        System.out.println(SUCCESS_MESSAGE);

    }

    static void resultPrint (int st, int ball){
        String resultMessage = "";
        resultMessage += resultBall(ball);
        resultMessage += resultSt(st);
        resultMessage += resultNothing(st, ball);

        System.out.println(resultMessage);
    }

    private static String resultNothing(int st, int ball) {
        if(st == 0 && ball == 0){
            return "Nothing";
        }
        return "";
    }


    private static String resultBall(int ball) {
        if(ball > 0){
            return ball + "볼 ";
        }
        return "";
    }

    private static String resultSt(int st) {
        if(st > 0){
            return st + "스트라이크";
        }
        return "";
    }
}
