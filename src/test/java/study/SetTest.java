package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1})
    void setContainsTrue(int num){
        // num 으로 4, 3, 2, 1 을 차례대로 받아와서 테스트 4번 실행
        // 코드 중복 작성 예방
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void setContainsFalse(int num){
        // num 으로 4, 3, 2, 1 을 차례대로 받아와서 테스트 4번 실행
        // 코드 중복 작성 예방
        assertThat(numbers.contains(num)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank(String input){
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"5, false", "4, false", "3, true", "2, true", "1, true"})
    void isNum(int num, boolean check){
        // 배열식으로 인수 두개 이상을 한번에 받아올 수 있다.
        // true 인 경우와 false 인 경우를 동시에 테스트 가능
        // 위의 setContainsTrue() 와 setContainsFalse() 메서드의 기능 합침.
        assertEquals(numbers.contains(num), check);
    }
}
