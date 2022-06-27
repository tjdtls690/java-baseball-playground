package com.jun_hyeok.baseball_game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {
    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike(){
        BallStatus status = com.play(new Ball(2, 3));
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        BallStatus status = com.play(new Ball(1, 3));
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        BallStatus status = com.play(new Ball(1, 4));
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
