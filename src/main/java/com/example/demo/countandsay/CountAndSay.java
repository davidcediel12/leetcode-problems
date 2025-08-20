package com.example.demo.countandsay;

public class CountAndSay {


    public String countAndSay(int n) {
        return countAndSay(n, "1");
    }

    private String countAndSay(int n, String sequence) {

        if (n == 1) {
            return sequence;
        }

        StringBuilder newSequence = new StringBuilder();

        int charCount = 0;
        char actualChar = 0;

        for (int i = 0; i < sequence.length(); i++) {

            if (charCount == 0) {
                charCount++;
                actualChar = sequence.charAt(i);
            } else if (actualChar == sequence.charAt(i)) {
                charCount++;
            } else {
                newSequence.append(charCount)
                        .append(actualChar);

                actualChar = sequence.charAt(i);
                charCount = 1;
            }
        }
        newSequence.append(charCount)
                .append(sequence.charAt(sequence.length()-1));

        return countAndSay(n-1, newSequence.toString());
    }
}
