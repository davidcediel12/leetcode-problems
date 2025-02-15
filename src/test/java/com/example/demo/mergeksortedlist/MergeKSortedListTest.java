package com.example.demo.mergeksortedlist;

import org.junit.jupiter.api.Test;

import static com.example.demo.mergeksortedlist.MergeKSortedList.ListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeKSortedListTest {

    MergeKSortedList mergeKSortedList = new MergeKSortedList();


    @Test
    void shouldMergeListCorrectly() {

        MergeKSortedList.ListNode[] lists = new MergeKSortedList.ListNode[]{
                new ListNode(1, new ListNode(4, new MergeKSortedList.ListNode(5))),
                new ListNode(1, new ListNode(3, new MergeKSortedList.ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        MergeKSortedList.ListNode expectedResult = new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));


        assertEquals(expectedResult, mergeKSortedList.mergeKLists(lists));
    }

}