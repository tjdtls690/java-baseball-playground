package com.jun_hyeok.base_ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGamePlayerTest {

    BaseballGamePlayer bp;
    int[] inputNumBox;

    @BeforeEach
    void setUp() {
        bp = new BaseballGamePlayer();

        Field field;
        try {
            field = bp.getClass().getDeclaredField("inputNumBox");
            field.setAccessible(true);
            inputNumBox = (int[]) field.get(bp);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"413, true", "410, false", "1456, false", "056, false", "955, false", "1000, false"})
    void saveNum(int num, boolean result) {
        boolean invoke = bp.saveNum(num);
        assertEquals(invoke, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"413, true", "410, false", "1456, false", "056, false", "955, false", "954, true", "1000, false"})
    void inputNumCheck(int num, boolean result){
        inputNumBox[0] = num / 100;
        inputNumBox[1] = num % 100 / 10;
        inputNumBox[2] = num % 10;

        boolean invoke = methodResult("inputNumCheck", num);

        assertEquals(invoke, result);
    }


    boolean methodResult(String methodName, int n1){
        Method method;
        try {
            method = bp.getClass().getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(bp, n1);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

}