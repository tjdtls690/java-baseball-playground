package com.jun_hyeok.baseball_game;

import com.jun_hyeok.baseball_game.domain.Ball;
import com.jun_hyeok.baseball_game.domain.Balls;
import com.jun_hyeok.baseball_game.domain.Judgment;
import com.jun_hyeok.baseball_game.input.Computer;
import com.jun_hyeok.baseball_game.input.InputView;
import com.jun_hyeok.baseball_game.output.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.gameStart();
    }

    private void gameStart() {
        boolean checkRepeat = true;
        while (checkRepeat) {
            checkRepeat = isRepeat();
        }
    }

    private boolean isRepeat() {
        ResultView resultView = new ResultView();
        play(resultView);
        resultView.restartAsk();
        return resultView.isRestart();
    }

    private void play(ResultView resultView) {
        boolean checkAnswer = false;
        Balls comBalls = getComBalls();
        while (!checkAnswer) {
            List<Ball> playerBallBox = getPlayerBallBox();
            checkAnswer = getGameResult(comBalls, playerBallBox, resultView);
        }
    }

    private boolean getGameResult(Balls comBalls, List<Ball> playerBallBox, ResultView resultView) {
        Judgment resultReport = comBalls.play(playerBallBox);
        resultView.resultPrint(resultReport);
        return resultReport.isGameEnd();
    }

    private List<Ball> getPlayerBallBox() {
        InputView player = new InputView();
        return player.getPlayerBallBox();
    }

    private Balls getComBalls() {
        Computer computer = new Computer();
        List<Integer> comNumBox = computer.getRanNum();
        return new Balls(comNumBox);
    }
}
