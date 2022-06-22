package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

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
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void isNothing(){
        BallStatus status = com.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void isIllegalArgumentException(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Ball(1, 10);
        }).withMessage("숫자는 1 ~ 9 까지만 가능합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Ball(3, 9);
        }).withMessage("볼의 갯수는 3개까지만 가능합니다.");
    }
}
