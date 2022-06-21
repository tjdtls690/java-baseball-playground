package com.jun_hyeok.base_ball;

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

            // InputView, OutputView
            // 입력 클래스, 출력 클래스를 따로 만든다.
        }
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
