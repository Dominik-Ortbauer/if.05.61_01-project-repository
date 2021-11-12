package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RomanNumberConverterTest
{
    @Test
    public void itShouldReturnI_Given1() {
        assertEquals("I", RomanNumberConverter.toRoman(1));
    }

    @Test
    public void itShouldReturnII_Given2() {
        assertEquals("II", RomanNumberConverter.toRoman(2));
    }

    @Test
    public void itShouldReturnIII_Given3() {
        assertEquals("III", RomanNumberConverter.toRoman(3));
    }

    @Test
    public void itShouldReturnV_Given5() {
        assertEquals("V", RomanNumberConverter.toRoman(5));
    }

    @Test
    public void itShouldReturnVIs_GivenBetween6And8() {
        assertEquals("VI", RomanNumberConverter.toRoman(6));
        assertEquals("VII", RomanNumberConverter.toRoman(7));
    }

    @Test
    public void itShouldReturnX_Given10() {
        assertEquals("X", RomanNumberConverter.toRoman(10));
    }

    @Test
    public void itShouldReturnXX_Given20() {
        assertEquals("XX", RomanNumberConverter.toRoman(20));
    }

    @Test
    public void itShouldReturnIV_Given4() {
        assertEquals("IV", RomanNumberConverter.toRoman(4));
    }

    @Test
    public void itShouldReturnIX_Given9() {
        assertEquals("IX", RomanNumberConverter.toRoman(9));
    }
}
