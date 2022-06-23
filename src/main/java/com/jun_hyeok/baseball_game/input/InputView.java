package com.jun_hyeok.baseball_game.input;

import com.jun_hyeok.baseball_game.domain.Judgment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String START_MESSAGE = "숫자를 입력해 주세요.";
    private final BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<Integer> getPlayerNum() {
        List<Integer> playerNum = new ArrayList<>();
        boolean isCorrectNum = true;
        while (isCorrectNum) {
            playerNum.clear();
            isCorrectNum = !checkInputNum(playerNum);
        }

        return playerNum;
    }

    private boolean checkInputNum(List<Integer> playerNum) {
        System.out.println(START_MESSAGE);
        int num;
        try {
            String input = br.readLine();
            num = Integer.parseInt(input);
        } catch (IOException | NumberFormatException e) {
            return false;
        }
        return checkDiffNum(playerNum, num);
    }

//    private boolean checkCorrectNum(List<Integer> playerNum, int num) {
//        if(num / 100 > 9 || num / 100 < 1 ||
//                num % 100 / 10 < 1 || num % 10 < 1){
//            return false;
//        }
//        return checkDiffNum(playerNum, num);
//    }

    private boolean checkDiffNum(List<Integer> playerNum, int num) {
        List<Integer> inputNum = Arrays.asList(num / 100, num % 100 / 10, num % 10);

        int len = 0;
        boolean isDiff = true;
        while(len < 3 && isDiff){
            isDiff = inputCheckNum(playerNum, inputNum.get(len));
            len++;
        }
        return isDiff;
    }

    private boolean inputCheckNum(List<Integer> playerNum, int num) {
        if(isDiffNum(playerNum, num)){
            return false;
        }
        inputNum(playerNum, num);
        return true;
    }

    private void inputNum(List<Integer> playerNum, int num) {
        playerNum.add(num);
    }

    private boolean isDiffNum(List<Integer> playerNum, int num){
        Judgment judgment = new Judgment();
        return judgment.isDifferent(playerNum, num);
    }
}
