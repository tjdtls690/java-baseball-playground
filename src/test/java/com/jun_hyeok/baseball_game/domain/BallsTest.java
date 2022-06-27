package com.jun_hyeok.baseball_game.domain;

import org.assertj.core.api.Assertions;
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
    @DisplayName("0 ball 0 strike == Nothing")
    void strike_0_ball_0(){
        Referee referee = com.play(Arrays.asList(new Ball(0, 4), new Ball(1, 5), new Ball(2, 6)));
        assertThat(referee.getStrike()).isEqualTo(0);
        assertThat(referee.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("3 ball 0 strike")
    void strike_0_ball_3(){
        Referee referee = com.play(Arrays.asList(new Ball(0, 2), new Ball(1, 3), new Ball(2, 1)));
        assertThat(referee.getStrike()).isEqualTo(0);
        assertThat(referee.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("0 ball 3 strike")
    void strike_3_ball_0(){
        Referee referee = com.play(Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3)));
        assertThat(referee.getStrike()).isEqualTo(3);
        assertThat(referee.getBall()).isEqualTo(0);
        assertThat(referee.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("1 ball 1 strike")
    void strike_1_ball_1(){
        Referee referee = com.play(Arrays.asList(new Ball(0, 1), new Ball(1, 3), new Ball(2, 4)));
        assertThat(referee.getStrike()).isEqualTo(1);
        assertThat(referee.getBall()).isEqualTo(1);
    }

    @Test
    void strike(){
        BallStatus status = com.play(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        BallStatus status = com.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
