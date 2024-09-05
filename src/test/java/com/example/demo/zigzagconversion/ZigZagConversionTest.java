package com.example.demo.zigzagconversion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    ZigZagConversion zigZagConversion = new ZigZagConversion();

    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING,3,PAHNAPLSIIGYIR",
            "PAYPALISHIRING,4,PINALSIGYAHRPI"
    })
    void shouldConvertToZigZagCorrectly(String original, Integer rows, String expected){

        String actual = zigZagConversion.convert(original, rows);
        assertEquals(expected, actual);
    }


    @Test
    void givenTwoCharsWordAndOneRowShouldConvertCorrectly(){
        String actual = zigZagConversion.convert("AB", 1);
        assertEquals("AB", actual);
    }
}