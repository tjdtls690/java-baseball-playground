package com.jun_hyeok.base_ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BaseballGamePlayer bp;
    private final BufferedReader br;

    private static final String START_MESSAGE = "숫자야구게임에 오신 것을 환영합니다.";
    private static final String RESTART_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public InputView() {
        bp = new BaseballGamePlayer();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    boolean restartMessageAndSelect(){
        int correctNumCheck = 0;
        while(correctNumCheck < 1 || correctNumCheck > 2){
            System.out.println(RESTART_QUESTION);
            correctNumCheck = getSelectNum();
        }

        return correctNumCheck == 1;
    }

    private int getSelectNum() {
        try {
            String selectStr = br.readLine();
            return Integer.parseInt(selectStr);
        } catch (IOException e) {
            return -1;
        }
    }

    void startMessagePrint(){
        System.out.println(START_MESSAGE);
    }

    int[] getPlayerNumBox () {
        boolean isCorrectNum = false;
        String correctNumOutput = "숫자를 입력해 주세요 : ";
        while(!isCorrectNum){
            System.out.print(correctNumOutput);
            int num = getInputNum();
            isCorrectNum = bp.saveNum(num);
            correctNumOutput = "올바른 숫자를 입력해 주세요 : ";
        }
        return bp.inputNumBox;
    }

    private int getInputNum () {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ie) {
            return -1;
        }
    }
}
