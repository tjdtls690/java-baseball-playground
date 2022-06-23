package com.jun_hyeok.baseball_game;

import com.jun_hyeok.baseball_game.domain.Referee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputView {
    public static final String GAME_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REPEAT_SELECT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final BufferedReader br;

    public OutputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }


    public boolean isRepeat() {
        System.out.println(GAME_SUCCESS);
        return isRepeatNum() == 1;
    }

    private int isRepeatNum() {
        boolean isCorrectNum = false;
        int num = -1;
        while(!isCorrectNum){
            System.out.println(REPEAT_SELECT_MESSAGE);
            num = selectNum();
            isCorrectNum = isCorrect(num);
        }
        return num;
    }

    private boolean isCorrect(int num) {
        return num != -1;
    }

    private int selectNum() {
        int num = 0;
        try {
            String numStr = br.readLine();
            num = Integer.parseInt(numStr);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return isRange(num);
    }

    private int isRange(int num) {
        if(num < 1 || num > 2){
            return -1;
        }
        return num;
    }

    public void resultPrint(Referee referee) {
        String result = "";

        result += ballResult(referee);
        result += strikeResult(referee);
        result += nothingResult(referee);

        System.out.println(result);
    }

    private String nothingResult(Referee referee) {
        if(referee.getStrike() == 0 && referee.getBall() == 0){
            return "Nothing";
        }
        return "";
    }

    private String strikeResult(Referee referee) {
        if(referee.getStrike() > 0){
            return referee.getStrike() + "스트라이크";
        }
        return "";
    }

    private String ballResult(Referee referee) {
        if(referee.getBall() > 0){
            return referee.getBall() + "볼 ";
        }
        return "";
    }
}
