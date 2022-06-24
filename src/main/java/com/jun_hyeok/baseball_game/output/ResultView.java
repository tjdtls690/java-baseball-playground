package com.jun_hyeok.baseball_game.output;

import com.jun_hyeok.baseball_game.domain.BallStatus;
import com.jun_hyeok.baseball_game.domain.Judgment;

public class ResultView {
    public void restartAsk(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void resultPrint(Judgment result){
        String resultMessage = getBallMessage(result);
        resultMessage += getStrikeMessage(result);
        resultMessage += getNothingMessage(result);
        System.out.println(resultMessage);
    }

    private String getNothingMessage(Judgment result) {
        if(result.getStrike() == 0 && result.getBall() == 0){
            return "Nothing";
        }
        return "";
    }

    private String getStrikeMessage(Judgment result) {
        if(result.getStrike() > 0){
            return result.getStrike() + "스트라이크";
        }
        return "";
    }

    private String getBallMessage(Judgment result) {
        if(result.getBall() > 0){
            return result.getBall() + "볼 ";
        }
        return "";
    }
}
