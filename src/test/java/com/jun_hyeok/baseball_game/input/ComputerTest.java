package com.jun_hyeok.baseball_game.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private Computer com;

    @BeforeEach
    void setUp() {
        com = new Computer();
    }

    @RepeatedTest(20)
    @DisplayName("컴퓨터 랜덤 숫자가 서로 다른 숫자인지 검증")
    void getComNumber() {
        List<Integer> comNumBox = com.getComNumber();
        assertThat(comNumBox.get(0)).isNotEqualTo(comNumBox.get(1));
        assertThat(comNumBox.get(1)).isNotEqualTo(comNumBox.get(2));
        assertThat(comNumBox.get(0)).isNotEqualTo(comNumBox.get(2));
        System.out.println(comNumBox);
    }
}