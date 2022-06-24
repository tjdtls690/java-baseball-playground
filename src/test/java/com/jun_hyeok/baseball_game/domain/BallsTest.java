package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls comBalls;

    @BeforeEach
    void setUp() {
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("0 ball 0 strike")
    void ball_0_strike_0(){
        Judgment judgment = comBalls.play(Arrays.asList(4, 5, 6));
        assertThat(judgment.getStrike()).isEqualTo(0);
        assertThat(judgment.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("0 Ball 3 Strike")
    void ball_0_strike_3(){
        Judgment judgment = comBalls.play(Arrays.asList(1, 2, 3));
        assertThat(judgment.getStrike()).isEqualTo(3);
        assertThat(judgment.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("3 Ball 0 Strike")
    void ball_3_strike_0(){
        Judgment judgment = comBalls.play(Arrays.asList(3, 1, 2));
        assertThat(judgment.getStrike()).isEqualTo(0);
        assertThat(judgment.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("1 Ball 1 Strike")
    void ball_1_strike_1(){
        Judgment judgment = comBalls.play(Arrays.asList(1, 3, 4));
        assertThat(judgment.getStrike()).isEqualTo(1);
        assertThat(judgment.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("Strike 검증")
    void strike(){
        BallStatus status = comBalls.play(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Ball 검증")
    void ball(){
        BallStatus status = comBalls.play(new Ball(0, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Nothing 검증")
    void nothing(){
        BallStatus status = comBalls.play(new Ball(0, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
