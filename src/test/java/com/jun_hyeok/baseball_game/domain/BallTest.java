package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {


    @Test
    void strike(){
        Ball com = new Ball(2, 5);
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        Ball com = new Ball(2, 5);
        BallStatus status = com.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        Ball com = new Ball(2, 5);
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
