package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {


    @Test
    @DisplayName("Nothing 이 잘 반환되는지 검증")
    void isNothing(){
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.isMatchUp(new Ball(1, 9));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
