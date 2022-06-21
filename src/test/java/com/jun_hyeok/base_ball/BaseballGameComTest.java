package com.jun_hyeok.base_ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGameComTest {

    BaseballGameCom bg;
    int[] ranNumBox;

    @BeforeEach
    void setUp() {
        bg = new BaseballGameCom();
        Field field;
        try {
            field = bg.getClass().getDeclaredField("ranNumBox");
            field.setAccessible(true);
            ranNumBox = (int[]) field.get(bg);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @RepeatedTest(10)
    void getRanNumBox() {
        ranNumBox = bg.getRanNumBox();
        assertThat(ranNumBox[0] != ranNumBox[1]).isTrue();
        assertThat(ranNumBox[1] != ranNumBox[2]).isTrue();
        assertThat(ranNumBox[0] != ranNumBox[2]).isTrue();
    }

    @RepeatedTest(10)
    void getRanNum() {
        ranNumBox[0] = 9;
        ranNumBox[1] = 5;
        int invoke = methodResult("getRanNum", -1);
        assertThat(ranNumBox).doesNotContain(invoke);
    }

    @ParameterizedTest
    @CsvSource(value = {"9, false", "5, false", "1, true", "2, true", "3, true", "4, true", "6, true", "7, true", "8, true"})
    void isUniqueCheck(int num, boolean result){
        ranNumBox[0] = 9;
        ranNumBox[1] = 5;
        boolean invoke = methodResult("isUniqueCheck", num, true);
        assertEquals(result, invoke);
    }

    boolean methodResult(String methodName, int num, boolean tmp){
        Method method;
        try {
            method = bg.getClass().getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(bg, num);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    int methodResult(String methodName, int tmp){
        Method method;
        try {
            method = bg.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            return (int) method.invoke(bg);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}