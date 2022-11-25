package xyz.nowaha.nlib.test;

import org.junit.jupiter.api.Test;
import xyz.nowaha.nlib.utils.RomanNumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTests {

    @Test
    public void testRomanNumerals() {
        assertEquals("0", RomanNumerals.toRoman(0));
        assertEquals("X", RomanNumerals.toRoman(10));
        assertEquals("XI", RomanNumerals.toRoman(11));
        assertEquals("XIV", RomanNumerals.toRoman(14));
        assertEquals("XV", RomanNumerals.toRoman(15));
        assertEquals("XVI", RomanNumerals.toRoman(16));
        assertEquals("CXVI", RomanNumerals.toRoman(116));
        assertEquals("CCLXXXIV", RomanNumerals.toRoman(284));
        assertEquals("MMMMMMMMMDLXXVIII", RomanNumerals.toRoman(9578));
    }

}
