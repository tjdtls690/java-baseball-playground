package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(2, 4);
    }

    @Test
    void isStrike(){
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void isBall(){
        BallStatus status = com.play(new Ball(3, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void isNothing(){
        BallStatus status = com.play(new Ball(3, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
