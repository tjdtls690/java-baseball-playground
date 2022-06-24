package com.jun_hyeok.baseball_game.output;

import com.jun_hyeok.baseball_game.domain.BallStatus;
import com.jun_hyeok.baseball_game.domain.Judgment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResultView {
    public static final String ERROR_MESSAGE = "숫자 1과 2 중 하나를 선택해주세요.";
    public static final String RESTART_SELECT_ASK_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final BufferedReader br;

    public ResultView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean isRestart() {
        return getCorrectSelectNum() == 1;
    }

    private int getCorrectSelectNum() {
        int num = 0;
        try{
            num = getSelectNum();
            isCorrectSelectNum(num);
            return num;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCorrectSelectNum();
        }
    }

    private void isCorrectSelectNum(int num) throws IllegalArgumentException {
        if (num < 1 || num > 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private int getSelectNum() throws IllegalArgumentException {
        int num;
        String numStr = null;
        try {
            numStr = br.readLine();
            num = Integer.parseInt(numStr);
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return num;
    }

    public void restartAsk() {
        System.out.println(RESTART_SELECT_ASK_MESSAGE);
    }

    public void resultPrint(Judgment result) {
        String resultMessage = getBallMessage(result);
        resultMessage += getStrikeMessage(result);
        resultMessage += getNothingMessage(result);
        System.out.println(resultMessage);
    }

    private String getNothingMessage(Judgment result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            return "Nothing";
        }
        return "";
    }

    private String getStrikeMessage(Judgment result) {
        if (result.getStrike() > 0) {
            return result.getStrike() + "스트라이크";
        }
        return "";
    }

    private String getBallMessage(Judgment result) {
        if (result.getBall() > 0) {
            return result.getBall() + "볼 ";
        }
        return "";
    }
}
