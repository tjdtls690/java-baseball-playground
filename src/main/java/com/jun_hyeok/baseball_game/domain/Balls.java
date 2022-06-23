package com.jun_hyeok.baseball_game.domain;

import com.jun_hyeok.baseball_game.input.Computer;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> comNumberBox;

    public Balls(List<Integer> comNumberBox) {
        this.comNumberBox = mapBall(comNumberBox);
    }

    private List<Ball> mapBall(List<Integer> numberBox) {
        List<Ball> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            addBall(resultList, numberBox.get(i), i);
        }

        return resultList;
    }

    private void addBall(List<Ball> resultList, int num, int idx) {
        Ball ball = null;
        try {
            ball = new Ball(idx, num);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
        resultList.add(ball);
    }

    private BallStatus play(Ball playerBall) {
        return comNumberBox.stream()
                .map(answer -> answer.play(playerBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }


    public Referee play(List<Integer> userNumberBox) {
        List<Ball> userBall = mapBall(userNumberBox);
        if (userBall.contains(null)) {
            return null;
        }

        return getResult(userBall);
    }

    private Referee getResult(List<Ball> userBall) {
        Referee result = new Referee();
        for (Ball ball : userBall) {
            BallStatus status = this.play(ball);
            result.report(status);
        }
        return result;
    }
}
