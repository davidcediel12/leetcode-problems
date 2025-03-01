package com.example.demo.reversenodeskgroup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseNodesKGroupTest {

    ReverseNodesKGroup reverseNodesKGroup = new ReverseNodesKGroup();


    @Test
    void shouldSwapCorrectly() {

        ReverseNodesKGroup.ListNode initial = new ReverseNodesKGroup.ListNode(1,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(3,
                        new ReverseNodesKGroup.ListNode(4))));


        ReverseNodesKGroup.ListNode expected = new ReverseNodesKGroup.ListNode(2,
                new ReverseNodesKGroup.ListNode(1, new ReverseNodesKGroup.ListNode(4,
                        new ReverseNodesKGroup.ListNode(3))));


        var actual = reverseNodesKGroup.reverseKGroup(initial, 2);

        assertEquals(expected, actual);

    }


    @Test
    void shouldSwapCorrectly2() {

        ReverseNodesKGroup.ListNode initial = new ReverseNodesKGroup.ListNode(1,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(3,
                        new ReverseNodesKGroup.ListNode(4,
                                new ReverseNodesKGroup.ListNode(5)))));


        ReverseNodesKGroup.ListNode expected = new ReverseNodesKGroup.ListNode(3,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(1,
                        new ReverseNodesKGroup.ListNode(4,
                                new ReverseNodesKGroup.ListNode(5)))));


        var actual = reverseNodesKGroup.reverseKGroup(initial, 3);

        assertEquals(expected, actual);

    }


    @Test
    void shouldSwapCorrectly3() {

        ReverseNodesKGroup.ListNode initial = new ReverseNodesKGroup.ListNode(1,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(3,
                        new ReverseNodesKGroup.ListNode(4,
                                new ReverseNodesKGroup.ListNode(5)))));


        ReverseNodesKGroup.ListNode expected = new ReverseNodesKGroup.ListNode(1,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(3,
                        new ReverseNodesKGroup.ListNode(4,
                                new ReverseNodesKGroup.ListNode(5)))));


        var actual = reverseNodesKGroup.reverseKGroup(initial, 1);

        assertEquals(expected, actual);

    }

    @Test
    void shouldSwapCorrectly4() {

        ReverseNodesKGroup.ListNode initial = new ReverseNodesKGroup.ListNode(1,
                new ReverseNodesKGroup.ListNode(2, new ReverseNodesKGroup.ListNode(3,
                        new ReverseNodesKGroup.ListNode(4))));


        ReverseNodesKGroup.ListNode expected = new ReverseNodesKGroup.ListNode(4,
                new ReverseNodesKGroup.ListNode(3, new ReverseNodesKGroup.ListNode(2,
                        new ReverseNodesKGroup.ListNode(1))));


        var actual = reverseNodesKGroup.reverseKGroup(initial, 4);

        assertEquals(expected, actual);

    }

}