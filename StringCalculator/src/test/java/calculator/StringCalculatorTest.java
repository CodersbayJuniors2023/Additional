package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private static StringCalculator stringCalculator;

    @BeforeAll
    static void setupCalculator() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testSubtractionPositive() {
        assertEquals(2, stringCalculator.subtract(5, 3));
        assertEquals(96, stringCalculator.subtract(100, 4));
    }

    @Test
    void testSubtractionNegative() {
        assertEquals(-2, stringCalculator.subtract(3, 5));
        assertEquals(-5, stringCalculator.subtract(0, 5));

    }

    @Test
    void testAddition() {
        assertEquals(6, stringCalculator.add("1,2,3"));
        assertEquals(12, stringCalculator.add("1,2,3,1,2,3"));
    }

    @Test
    void testAdditionNewlineChars() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(12, stringCalculator.add("1,2\n3,1,2,3"));
    }

    @Test
    void testStringSubtractionPositive() {
        assertEquals(7, stringCalculator.subtract("10,2,1"));
        assertEquals(48, stringCalculator.subtract("100,2,50"));
    }

    @Test
    void testStringSubtractionPositiveNewlineChars() {
        assertEquals(7, stringCalculator.subtract("10\n2,1"));
        assertEquals(48, stringCalculator.subtract("100,2\n50"));
    }

    @Test
    void testStringSubtractionNegative() {
        assertEquals(-11, stringCalculator.subtract("1,2,10"));
        assertEquals(-669, stringCalculator.subtract("255,369,555"));
    }

    @Test
    void testStringSubtractionNegativeNewlineChars() {
        assertEquals(-11, stringCalculator.subtract("1,2\n10"));
        assertEquals(-669, stringCalculator.subtract("255\n369,555"));
    }

    @Test
    void testMultiply() {
        assertEquals(24, stringCalculator.multiply("2,3,4"));
        assertEquals(64, stringCalculator.multiply("2,2,2,2,2,2"));
    }

    @Test
    void testMultiplyNewlineChars() {
        assertEquals(24, stringCalculator.multiply("2,3\n4"));
        assertEquals(64, stringCalculator.multiply("2,2\n2\n2,2\n2"));
    }

    @Test
    void checkCorrectBracketsTest() {
        assertTrue(stringCalculator.checkBrackets("{}"));
        assertTrue(stringCalculator.checkBrackets("{{{}}}"));
    }

    @Test
    void checkWrongBracketsTest() {
        assertFalse(stringCalculator.checkBrackets("{"));
        assertFalse(stringCalculator.checkBrackets("{{{}}"));
    }

    @Test
    void checkBracketsExceptionTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.checkBrackets("not a bracket"));

        assertEquals("Wrong parameter, only { or } is allowed", exception.getMessage());
    }
}
