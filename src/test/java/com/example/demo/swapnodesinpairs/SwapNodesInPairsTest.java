package com.example.demo.swapnodesinpairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {

    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

    @Test
    void shouldSwapCorrectly(){

        SwapNodesInPairs.ListNode initial = new SwapNodesInPairs.ListNode(1,
                new SwapNodesInPairs.ListNode(2, new SwapNodesInPairs.ListNode(3,
                        new SwapNodesInPairs.ListNode(4))));


        SwapNodesInPairs.ListNode expected = new SwapNodesInPairs.ListNode(2,
                new SwapNodesInPairs.ListNode(1, new SwapNodesInPairs.ListNode(4,
                        new SwapNodesInPairs.ListNode(3))));


        var actual = swapNodesInPairs.swapPairs(initial);

        assertEquals(expected, actual);

    }

}