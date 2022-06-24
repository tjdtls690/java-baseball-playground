package com.jun_hyeok.baseball_game.input;

import com.jun_hyeok.baseball_game.domain.Ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String ERROR_MESSAGE = "서로 다른 1 ~ 9 까지의 3개 '숫자'만 입력 가능합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 3;
    private final BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<Ball> getPlayerBallBox() {
        List<Ball> playerBallBox = new ArrayList<>();
        boolean checkCorrectNum = false;
        while(!checkCorrectNum){
            playerBallBox.clear();
            checkCorrectNum = isCorrectInputNum(playerBallBox);
        }
        return playerBallBox;
    }

    private boolean isCorrectInputNum(List<Ball> playerBallBox) {
        try {
            int num = getInputNum();
            List<Integer> playerNumBox = checkDiffAndGetNumBox(num);
            inputPlayerBallBox(playerBallBox, playerNumBox);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Integer> checkDiffAndGetNumBox(int num) throws IllegalArgumentException{
        int num1 = num / 100;
        int num2 = num % 100 / 10;
        int num3 = num % 10;
        if(num1 == num2 || num2 == num3 || num1 == num3){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return Arrays.asList(num / 100, num % 100 / 10, num % 10);
    }


    private int getInputNum() throws IllegalArgumentException{
        System.out.print(INPUT_MESSAGE);
        int num;
        try {
            String numStr = br.readLine();
            num = Integer.parseInt(numStr);
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return num;
    }

    private void inputPlayerBallBox(List<Ball> playerBallBox, List<Integer> playerNumBox) throws IllegalArgumentException{
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            playerBallBox.add(new Ball(i, playerNumBox.get(i)));
        }
    }
}
