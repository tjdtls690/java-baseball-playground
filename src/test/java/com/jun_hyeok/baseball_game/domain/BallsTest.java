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
    @DisplayName("Strike 가 잘 반환되는지 검증")
    void isStrike(){
        BallStatus status = com.play(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Ball 이 잘 반환되는지 검증")
    void isBall(){
        BallStatus status = com.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Nothing 이 잘 반환되는지 검증")
    void isNothing(){
        BallStatus status = com.play(new Ball(1, 9));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
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
