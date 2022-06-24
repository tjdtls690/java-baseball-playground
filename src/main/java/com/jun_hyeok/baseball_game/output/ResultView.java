package com.jun_hyeok.baseball_game.output;

import com.jun_hyeok.baseball_game.domain.BallStatus;
import com.jun_hyeok.baseball_game.domain.Judgment;

public class ResultView {
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
