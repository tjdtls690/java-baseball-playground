import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorUtilsTest {
    StringCalculatorUtils stringCalculatorUtils;

    @BeforeEach
    void setUp() {
        stringCalculatorUtils = new StringCalculatorUtils();
    }

    @ParameterizedTest
    @CsvSource(value = {"7, 4 3", "11, 7 4"})
    void add(int result, String input) {
        String[] values = input.split(" ");
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[1]);
        assertEquals(result, stringCalculatorUtils.add(num1, num2));
    }

    @ParameterizedTest
    @CsvSource(value = {"-2, 4 6", "20, 86 66"})
    void subtract(int result, String input) {
        String[] values = input.split(" ");
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[1]);
        assertEquals(result, stringCalculatorUtils.subtract(num1, num2));
    }

    @ParameterizedTest
    @CsvSource(value = {"-56, -7 8", "21, 3 7"})
    void multiply(int result, String input) {
        String[] values = input.split(" ");
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[1]);
        assertEquals(result, stringCalculatorUtils.multiply(num1, num2));
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 18 5", "4, 22 5"})
    void divide(int result, String input) {
        String[] values = input.split(" ");
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[1]);
        assertEquals(result, stringCalculatorUtils.divide(num1, num2));
    }

    @ParameterizedTest
    @CsvSource(value = {"25, 18 + 7", "21, 7 * 3", "-10, 8 - 18", "11, 23 / 2"})
    void calculateAll(int result, String input) {
        String[] values = input.split(" ");
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[2]);
        char symbol = values[1].charAt(0);
        assertEquals(result, stringCalculatorUtils.calculateAll(num1, num2, symbol));
    }
}