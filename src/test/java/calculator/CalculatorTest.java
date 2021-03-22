package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    // Step 1

    @Test
    @DisplayName("Adding two numbers")
    void addingTwoNumbers() {

        assertEquals(3, calculator.add("1,2"));

    }

    @Test
    @DisplayName("Adding only one number")
    void addingOneNumber() {

        assertEquals(1, calculator.add("1"));

    }

    @Test
    @DisplayName("Adding one empty string")
    void addingEmptyString() {

        assertEquals(0, calculator.add(""));

    }


    // Step 2


    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "1,2,3,4:10", "1,2,3,4,5:15"}, delimiter = ':')
    @DisplayName("adding multiply numbers")
    void addingMultipleNumbers(String input, int expected) {

        assertEquals(expected, calculator.add(input));


    }

    // Step 3

    @Test
    @DisplayName("adding with new lines")
    void addingWithNewLines() {

        assertEquals(6, calculator.add("1\n2,3"));

    }

    // Step 4


    @Test
    @DisplayName("Adding with more delimiters")
    void addingWithDifferentDelimiters() {

        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(15, calculator.add("1/2\n3;4,5"));

    }


    // Step 5

    @Test
    @DisplayName("Adding negative number")
    void addingNegativeNumber() {

        var iae = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,-10"));

        assertEquals("Negative numbers not allowed -1 -10", iae.getMessage());

    }


    // Step 6

    @Test
    @DisplayName("Excluding numbers bigger than 1000")
    void excludeNumbersBiggerThan1000() {

        assertEquals(6, calculator.add("1,5,1001"));

    }


    // Step 7


    @Test
    @DisplayName("Delimiters of any length")
    void delimitersOfAnyLength() {

        assertEquals(6, calculator.add("//[***]\n1***2***3"));

    }


    // Step 8


    @Test
    @DisplayName("Multiple delimiters")
    void allowingMultipleDelimiters() {

        assertEquals(6, calculator.add("1*2%3"));

    }


}
