package com.jun_hyeok.base_ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BaseballGamePlayer bp;
    private final BufferedReader br;

    private static final String startMessage = "숫자야구게임에 오신 것을 환영합니다.";

    public InputView() {
        bp = new BaseballGamePlayer();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    static void startMessagePrint(){
        System.out.println(startMessage);
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
