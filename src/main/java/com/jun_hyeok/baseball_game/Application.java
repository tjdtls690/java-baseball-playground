package com.jun_hyeok.baseball_game;

import com.jun_hyeok.baseball_game.domain.Balls;
import com.jun_hyeok.baseball_game.domain.Referee;
import com.jun_hyeok.baseball_game.input.Computer;
import com.jun_hyeok.baseball_game.input.InputView;

import java.util.List;
import java.util.Map;

public class Application {
    private final InputView inputView;
    private final OutputView outputView;

    public Application() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    void run(){
        boolean isRepeat = true;
        while(isRepeat){
            isRepeat = playGame();
        }
    }

    private boolean playGame() {
        Computer com = new Computer();
        List<Integer> comResult = com.getComNumber();
        Balls comNum = new Balls(comResult);
        boolean isAnswer = false;
        while(!isAnswer){
            Referee referee = inputPlayerNum(inputView, comNum);
            outputView.resultPrint(referee);
            isAnswer = referee.isGameEnd();
        }
        System.out.println(comResult);
        return outputView.isRepeat();
    }

    private Referee inputPlayerNum(InputView inputView, Balls comNum) {
        boolean isWrongNum = true;
        Referee referee = null;
        while(isWrongNum){
            List<Integer> userNum = inputView.getPlayerNum();
            referee = comNum.play(userNum);
            isWrongNum = isNullNum(referee);
        }
        return referee;
    }

    private boolean isNullNum(Referee referee) {
        return referee == null;
    }


    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
