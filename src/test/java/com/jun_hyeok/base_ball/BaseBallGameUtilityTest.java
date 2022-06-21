package com.jun_hyeok.base_ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBallGameUtilityTest {

    BaseBallGameUtility bu;

    @BeforeEach
    void setUp() {
        bu = new BaseBallGameUtility();
    }

    @DisplayName("번호 비교 최종 결과")
    @ParameterizedTest
    @MethodSource("compareData")
    void compare(int[] playerNumBox, int[] comNumBox, boolean check){
        assertEquals(BaseBallGameUtility.compare(playerNumBox, comNumBox), check);
    }

    static Stream<Arguments> compareData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 5}, false)
        );
    }

    @DisplayName("볼 숫자 구하기")
    @ParameterizedTest
    @MethodSource("getBallData")
    void getBall(int[] playerNumBox, int[] comNumBox, int ball){
        int invoke = methodResult("getBall", playerNumBox, comNumBox);
        assertEquals(invoke, ball);
    }

    static Stream<Arguments> getBallData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 0),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 5}, 1),
                Arguments.of(new int[]{4, 7, 2}, new int[]{2, 4, 7}, 3)
        );
    }

    @DisplayName("볼인지 여부 확인")
    @ParameterizedTest
    @MethodSource("checkBallData")
    void checkBall(int[] comNumBox, int playerNum, int idx, int assertNum){
        int invoke = methodResult("checkBall", comNumBox, playerNum, idx);
        assertEquals(invoke, assertNum);
    }

    public static Stream<Arguments> checkBallData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 3, 2, 0),
                Arguments.of(new int[]{4, 8, 7}, 3, 0, 0),
                Arguments.of(new int[]{1, 2, 3}, 3, 1, 1),
                Arguments.of(new int[]{5, 7, 8}, 5, 0, 0),
                Arguments.of(new int[]{5, 7, 8}, 7, 0, 1)
        );
    }

    @DisplayName("스트라이크 숫자 구하기")
    @ParameterizedTest
    @MethodSource("getStData")
    void getSt(int[] playerNum, int[] comNum, int assertNum){
        int invoke = methodResult("getSt", playerNum, comNum);
        assertEquals(invoke, assertNum);
    }

    public static Stream<Arguments> getStData() {
        return Stream.of(
                Arguments.of(new int[]{3, 7, 5}, new int[]{3, 7, 5}, 3),
                Arguments.of(new int[]{3, 7, 5}, new int[]{3, 5, 7}, 1),
                Arguments.of(new int[]{3, 7, 5}, new int[]{5, 3, 7}, 0),
                Arguments.of(new int[]{1, 2, 3}, new int[]{5, 7, 3}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}, 2)
        );
    }

    @DisplayName("스트라이크인지 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"3, 3, 1", "3, 2, 0", "5, 5, 1", "8, 3, 0"})
    void checkSt(int playerNum, int comNum, int assertNum){
        int invoke = methodResult("checkSt", playerNum, comNum);
        assertEquals(invoke, assertNum);
    }

    int methodResult(String methodName, int num1, int num2){
        Method method;
        try {
            method = bu.getClass().getDeclaredMethod(methodName, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(bu, num1, num2);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    int methodResult(String methodName, int[] arr1, int num1, int num2){
        Method method;
        try {
            method = bu.getClass().getDeclaredMethod(methodName, int[].class, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(bu, arr1, num1, num2);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    int methodResult(String methodName, int[] arr1, int[] arr2){
        Method method;
        try {
            method = bu.getClass().getDeclaredMethod(methodName, int[].class, int[].class);
            method.setAccessible(true);
            return (int) method.invoke(bu, arr1, arr2);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}