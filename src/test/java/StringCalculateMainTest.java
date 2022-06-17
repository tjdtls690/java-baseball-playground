import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculateMainTest {
    StringCalculateMain main;

    @BeforeEach
    void setUp() {
        main = new StringCalculateMain();
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 3 + 5 / 3 * 2", "80, 10 * 30 / 4 + 5", "1, 1"})
    void stringCalculate(int result, String input) {
        assertEquals(result, main.StringCalculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 2 * 5", "s + ㄴ + 2 * 9"})
    @DisplayName("공백 혹은 에러")
    void stringCalculateError(String input){
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            main.StringCalculate(input);
        });
    }
}