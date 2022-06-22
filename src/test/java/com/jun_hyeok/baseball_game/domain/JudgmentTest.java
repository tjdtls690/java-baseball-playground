package com.jun_hyeok.baseball_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class JudgmentTest {
    private List<Integer> comNumBox;

    @BeforeEach
    void setUp() {
        comNumBox = Arrays.asList(1, 2, 3);
    }

    @ParameterizedTest
    @DisplayName("해당 숫자가 먼저 저장된 숫자들과 다른지 검증")
    @CsvSource({"1, false", "3, false", "4, true", "9, true"})
    void isDifferent(int num, boolean assertBool){
        Judgment judgment = new Judgment();
        assertEquals(judgment.isDifferent(comNumBox, num), assertBool);
    }

    @ParameterizedTest
    @DisplayName("숫자가 1 ~ 9 안에 속하는지 검증")
    @CsvSource({"1, true", "9, true", "10, false", "0, false"})
    void isInRange(int num, boolean assertBool){
        Judgment judgment = new Judgment();
        assertEquals(judgment.isInRange(num), assertBool);
    }
}
