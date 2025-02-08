package com.example.demo.removennode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RemoveNNodeTest {


    RemoveNNode removeNNode = new RemoveNNode();


    @Test
    void shouldDeleteTheCorrectItem() {

        RemoveNNode.ListNode head = new RemoveNNode.ListNode(1,
                new RemoveNNode.ListNode(2,
                        new RemoveNNode.ListNode(3,
                                new RemoveNNode.ListNode(4,
                                        new RemoveNNode.ListNode(5, null)))));


        RemoveNNode.ListNode expectedHead = new RemoveNNode.ListNode(1,
                new RemoveNNode.ListNode(2,
                        new RemoveNNode.ListNode(3,
                                new RemoveNNode.ListNode(5, null))));


        RemoveNNode.ListNode actualHead = removeNNode.removeNthFromEnd(head, 2);

        assertEquals(expectedHead, actualHead);


    }


    @Test
    void shouldReturnEmptyValue() {

        RemoveNNode.ListNode head = new RemoveNNode.ListNode(1, null);

        RemoveNNode.ListNode actualHead = removeNNode.removeNthFromEnd(head, 1);

        assertNull(actualHead);


    }

}