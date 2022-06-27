package com.jun_hyeok.baseball_game.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @RepeatedTest(10)
    @DisplayName("컴퓨터의 랜덤 3가지 숫자가 서로 다른 수인지 검증")
    void getComNumBox() {
        Computer com = new Computer();
        List<Integer> comNumBox = com.getComNumBox();
        assertThat(comNumBox.get(0)).isNotEqualTo(comNumBox.get(1));
        assertThat(comNumBox.get(0)).isNotEqualTo(comNumBox.get(2));
        assertThat(comNumBox.get(1)).isNotEqualTo(comNumBox.get(2));
        System.out.println(comNumBox);
    }
}