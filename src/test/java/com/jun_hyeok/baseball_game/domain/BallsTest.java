package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("1 strike 1 ball")
    void strike1ball1(){
        Referee referee = com.play(Arrays.asList(2, 4, 3));
        assertThat(referee.getStrike()).isEqualTo(1);
        assertThat(referee.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3 strike 0 ball")
    void strike3ball0(){
        Referee referee = com.play(Arrays.asList(1, 2, 3));
        assertThat(referee.getStrike()).isEqualTo(3);
        assertThat(referee.getBall()).isEqualTo(0);
        assertThat(referee.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("1 ~ 9 범위를 벗어날 경우 null 반환 검증")
    void getNull(){
        Referee referee = com.play(Arrays.asList(1, 2, 10));
        assertThat(referee).isEqualTo(null);
    }

    @Test
    @DisplayName("0 strike 3 ball")
    void strike0ball3(){
        Referee referee = com.play(Arrays.asList(3, 1, 2));
        assertThat(referee.getStrike()).isEqualTo(0);
        assertThat(referee.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("0 strike 0 ball")
    void strike0ball0(){
        Referee referee = com.play(Arrays.asList(4, 5, 6));
        assertThat(referee.getStrike()).isEqualTo(0);
        assertThat(referee.getBall()).isEqualTo(0);
    }
}
