import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void add() {
        assertEquals(6, cal.add(2, 4));
    }

    @Test
    void subtract() {
        assertEquals(7, cal.subtract(14,7));
    }

    @Test
    void multiply() {
        assertEquals(40, cal.multiply(5, 8));
    }

    @Test
    void divide() {
        assertEquals(2, cal.divide(8, 3));
    }

    @AfterEach
    void tearDown() {
        cal = null;
    }
}