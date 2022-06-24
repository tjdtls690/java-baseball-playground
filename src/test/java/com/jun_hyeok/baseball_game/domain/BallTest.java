package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball comBall;

    @BeforeEach
    void setUp() {
        comBall = new Ball(1, 4);
    }

    @Test
    @DisplayName("Strike 검증")
    void strike(){
        BallStatus status = comBall.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Ball 검증")
    void ball(){
        BallStatus status = comBall.play(new Ball(0, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Nothing 검증")
    void nothing(){
        BallStatus status = comBall.play(new Ball(0, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
