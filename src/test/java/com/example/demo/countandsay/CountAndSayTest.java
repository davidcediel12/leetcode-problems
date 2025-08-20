package com.example.demo.countandsay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAndSayTest {



    CountAndSay countAndSay = new CountAndSay();

    @Test
    void shouldReturnOneWhenSequenceIsOne(){

        assertEquals("1", countAndSay.countAndSay(1));
    }


    @Test
    void shouldReturnCorrectSequence(){
        assertEquals("1211", countAndSay.countAndSay(4));
    }

    @Test
    void shouldReturnCorrectSequence2(){
        assertEquals("111221", countAndSay.countAndSay(5));
    }

}