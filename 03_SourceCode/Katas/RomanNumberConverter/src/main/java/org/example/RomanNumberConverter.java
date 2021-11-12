package org.example;

public class RomanNumberConverter
{
    public static String toRoman(int arabicNumber) {
        var romanNumber = "";
        for (var numeral : Numeral.values()){
            while (arabicNumber >= numeral.mArabic){
                romanNumber += numeral.mRoman;
                arabicNumber -= numeral.mArabic;
            }
        }
        return romanNumber;
    }

    public static int toArabic(String romanNumber) {
        var sum = 0;
        var index = 0;
        for(var numeral : Numeral.values()) {
            while(romanNumber.startsWith(numeral.mRoman)) {
                sum += numeral.mArabic;
                romanNumber = romanNumber.substring(numeral.mRoman.length());
            }
        }
        return sum;
    }

    enum Numeral{
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private final int mArabic;
        private final String mRoman;

        Numeral(int arabic, String roman) {
            mArabic = arabic;
            mRoman = roman;
        }
    }
}
