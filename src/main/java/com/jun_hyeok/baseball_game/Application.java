package com.jun_hyeok.baseball_game;

import com.jun_hyeok.baseball_game.domain.Ball;
import com.jun_hyeok.baseball_game.domain.Balls;
import com.jun_hyeok.baseball_game.domain.Referee;
import com.jun_hyeok.baseball_game.input.Computer;
import com.jun_hyeok.baseball_game.input.InputView;
import com.jun_hyeok.baseball_game.output.ResultView;

import javax.xml.transform.Result;
import java.util.List;

public class Application {
    public void playGame() {
        boolean checkRestart = true;
        while (checkRestart) {
            playBallMatch();
            checkRestart = isRestart();
        }
    }

    private void playBallMatch() {
        boolean isGameEnd = false;
        Balls comBalls = getComBalls();
        while (!isGameEnd) {
            Referee result = getResult(comBalls);
            resultPrint(result);
            isGameEnd = result.isGameEnd();
        }
    }

    private void resultPrint(Referee result) {
        ResultView resultReport = new ResultView();
        resultReport.resultPrint(result);
    }

    private Referee getResult(Balls comBalls) {
        List<Ball> playerBallBox = getPlayerBallBox();
        return comBalls.play(playerBallBox);
    }

    private boolean isRestart() {
        System.out.println(InputView.CONGRATULATION_AND_GAME_END_MESSAGE);
        return InputView.getSelectRestartNum() == 1;
    }

    private List<Ball> getPlayerBallBox() {
        return InputView.getPlayerBallBox();
    }

    private Balls getComBalls() {
        Computer comInput = new Computer();
        List<Integer> comNumBox = comInput.getComNumBox();
        return new Balls(comNumBox);
    }

    public static void main(String[] args) {
        Application baseballGame = new Application();
        baseballGame.playGame();
    }
}
