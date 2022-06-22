package com.jun_hyeok.baseball_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> comNumberBox;

    public Balls(List<Integer> comNumberBox) {
        this.comNumberBox = mapBall(comNumberBox);
    }

    private List<Ball> mapBall(List<Integer> comNumberBox) {
        List<Ball> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            resultList.add(new Ball(i, comNumberBox.get(i)));
        }
        return resultList;
    }

    public BallStatus isMatchUp(Ball playerBall) {
        return this.checkNum(playerBall);
    }

    private BallStatus checkNum(Ball playerBall) {
        return comNumberBox.stream()
                .map(answer -> answer.play(playerBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
