package com.example.demo.integertoroman;

public class IntegerToRoman {
    public String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();

        while (num > 0) {
            int digit = Integer.parseInt(String.valueOf(num).substring(0, 1));
            boolean subtractiveForm = digit == 9 || digit == 4;

            if (num >= 1000) {
                roman.append("M".repeat(digit));
                num -= (1000 * digit);
            } else if (num >= 500) {
                if (subtractiveForm) {
                    roman.append("CM");
                    num -= 900;
                } else {
                    roman.append("D");
                    num -= 500;
                }

            } else if (num >= 100) {
                if (subtractiveForm) {
                    roman.append("CD");
                    num -= 400;
                } else {
                    roman.append("C".repeat(digit));
                    num -= (100 * digit);
                }
            } else if (num >= 50) {
                if (subtractiveForm) {
                    roman.append("XC");
                    num -= 90;
                } else {
                    roman.append("L");
                    num -= 50;
                }
            } else if (num >= 10) {
                if (subtractiveForm) {
                    roman.append("XL");
                    num -= 40;
                } else {
                    roman.append("X".repeat(digit));
                    num -= (10 * digit);
                }
            } else if (num >= 5) {
                if (subtractiveForm) {
                    roman.append("IX");
                    num -= 9;
                } else {
                    roman.append("V");
                    num -= 5;
                }
            } else {
                if (subtractiveForm) {
                    roman.append("IV");
                    num -= 4;
                } else {
                    roman.append("I".repeat(num));
                    num = 0;
                }
            }
        }

        return roman.toString();

    }

}
