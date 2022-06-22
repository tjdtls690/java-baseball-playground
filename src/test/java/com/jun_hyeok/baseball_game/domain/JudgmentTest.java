package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgmentTest {

    @ParameterizedTest
    @DisplayName("해당 숫자가 먼저 저장된 숫자들과 다른지 검증")
    @CsvSource({"1, false", "3, false", "4, true", "9, true"})
    void isDifferent(int num, boolean assertBool){
        Judgment judgment = new Judgment();
        assertEquals(judgment.isDifferent(Arrays.asList(1, 2, 3), num), assertBool);
    }

    @ParameterizedTest
    @DisplayName("숫자가 1 ~ 9 안에 속하는지 검증")
    @CsvSource({"1, true", "9, true", "10, false", "0, false"})
    void isInRange(int num, boolean assertBool){
        Judgment judgment = new Judgment();
        assertEquals(judgment.isInRange(num), assertBool);
    }
}
