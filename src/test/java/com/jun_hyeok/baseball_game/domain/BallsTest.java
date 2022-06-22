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
        BallStatus status = com.isMatchUp(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Ball 이 잘 반환되는지 검증")
    void isBall(){
        BallStatus status = com.isMatchUp(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Nothing 이 잘 반환되는지 검증")
    void isNothing(){
        BallStatus status = com.isMatchUp(new Ball(1, 9));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
