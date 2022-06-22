package com.jun_hyeok.baseball_game.domain;

import java.util.List;

public class Judgment {

    public boolean isDifferent(List<Integer> currentList, int num) {
        return !currentList.contains(num);
    }
}
