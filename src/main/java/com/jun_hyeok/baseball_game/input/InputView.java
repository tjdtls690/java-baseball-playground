package com.jun_hyeok.baseball_game.input;

import com.jun_hyeok.baseball_game.domain.Ball;
import com.jun_hyeok.baseball_game.domain.BallPosition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String ERROR_MESSAGE_NUMBER_FORMAT = "'숫자'만 입력 가능합니다.";
    public static final String INPUT_START_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String ERROR_MESSAGE_DIFF = "3개의 수가 서로 달라야 합니다.";
    private final BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // List<Ball> 타입인 플레이어 볼 리스트를 반환
    // 3개의 수가 서로 다른 수인지, 그리고 각 숫자가 1 ~ 9 까지의 숫자인지 검증
    public List<Ball> getPlayerBallBox(){
        try{
            return convertToPlayerBallBox();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getPlayerBallBox();
        }
    }

    // List<Integer> 를 List<Ball> 로 변환 후, 반환
    private List<Ball> convertToPlayerBallBox() throws IllegalArgumentException{
        List<Ball> playerBallBox = new ArrayList<>();
        List<Integer> playerNumBox = getPlayerNumBox();
        for (int i = BallPosition.MIN_POSITION; i < BallPosition.MAX_POSITION; i++) {
            playerBallBox.add(new Ball(i, playerNumBox.get(i)));
        }
        System.out.println(playerNumBox);
        return playerBallBox;
    }

    // List<Integer> 타입인 플레이어 숫자리스트를 반환
    private List<Integer> getPlayerNumBox() throws IllegalArgumentException{
        int playerNum = getPlayerNum();
        return getCorrectPlayerNumBox(playerNum);
    }


    // 플레이어의 숫자를 입력
    // 숫자 타입인지 검증
    private int getPlayerNum() throws IllegalArgumentException{
        try{
            System.out.print(INPUT_START_MESSAGE);
            String numStr = br.readLine();
            return Integer.parseInt(numStr);
        }catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_FORMAT);
        }
    }

    // 3개의 수가 서로 다른 수임을 검증 후, List<Integer> 타입인 플레이어 숫자리스트 반환
    private List<Integer> getCorrectPlayerNumBox(int playerNum) throws IllegalArgumentException{
        List<Integer> playerNumBox = InputPlayerNum(playerNum);
        if(playerNumBox.get(0) == playerNumBox.get(1) || playerNumBox.get(0) == playerNumBox.get(2) ||
                playerNumBox.get(1) == playerNumBox.get(2)){
            throw new IllegalArgumentException(ERROR_MESSAGE_DIFF);
        }
        return playerNumBox;
    }

    private List<Integer> InputPlayerNum(int playerNum) {
        return Arrays.asList(playerNum / 100, playerNum % 100 / 10, playerNum % 10);
    }
}
