package com.jun_hyeok.baseball_game.output;

import com.jun_hyeok.baseball_game.domain.Referee;

public class ResultView {
    public void resultPrint(Referee result) {
        String resultMessage = "";
        resultMessage += getBallMessage(result);
        resultMessage += getStrikeMessage(result);
        resultMessage += getNothingMessage(result);
        System.out.println(resultMessage);
    }

    private String getNothingMessage(Referee result) {
        int ball = result.getBall();
        int strike = result.getStrike();
        if (ball == 0 && strike == 0) {
            return "Nothing";
        }
        return "";
    }

    private String getStrikeMessage(Referee result) {
        int strike = result.getStrike();
        if (strike > 0) {
            return strike + "스트라이크";
        }
        return "";
    }

    private String getBallMessage(Referee result) {
        int ball = result.getBall();
        if (ball > 0) {
            return ball + "볼 ";
        }
        return "";
    }


}
