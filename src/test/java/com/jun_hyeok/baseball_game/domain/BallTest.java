package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(2, 5);
    }

    @Test
    void strike(){
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        BallStatus status = com.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
