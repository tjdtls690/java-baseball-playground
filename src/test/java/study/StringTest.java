package study;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @Nested
    @DisplayName("문자열")
    class testString{
        @Test
        void replace() {
            String actual = "abc".replace("b", "d");
            assertThat(actual).isEqualTo("adc");
        }

        @Test
        void split(){
            String[] arr = "1,2".split(",");
            assertThat(arr).contains("1", "2");
        }

        @Test
        void splitExactly(){
            String[] arr = "1".split(",");
            assertThat(arr).containsExactly("1");
        }

        @Test
        void subString(){
            String str = "(1,2)".substring(1, 4);
            assertThat(str).isEqualTo("1,2");
        }
    }


    @Nested
    @DisplayName("예외")
    class TestThrown{

        @Test
        @DisplayName("예외 only1")
        void StringIndexOutOfBoundException1(){
            assertThatThrownBy(() -> {
                "abcd".charAt(4);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("index");
        }

        @Test
        @DisplayName("예외 only2")
        void StringIndexOutOfBoundException2(){
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        throw new StringIndexOutOfBoundsException("boom!");
                    }).withMessage("boom!").withMessageMatching("boom!");
        }

        @Test
        @DisplayName("예외 extends1")
        void StringIndexOutOfBoundException3(){
            assertThatThrownBy(() -> {
                "abcd".charAt(4);
            }).isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        @DisplayName("예외 extends2")
        void StringIndexOutOfBoundException4(){
            assertThatThrownBy(() -> {
                "abcd".charAt(4);
            }).isInstanceOf(Exception.class);
        }

    }
}
