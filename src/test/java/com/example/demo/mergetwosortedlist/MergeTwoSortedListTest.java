package com.example.demo.mergetwosortedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeTwoSortedListTest {

    MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();


    @Test
    void shouldMergeListCorrectly() {

        MergeTwoSortedList.ListNode l1 = new MergeTwoSortedList.ListNode(1,
                new MergeTwoSortedList.ListNode(2,
                        new MergeTwoSortedList.ListNode(4, null)));

        MergeTwoSortedList.ListNode l2 = new MergeTwoSortedList.ListNode(1,
                new MergeTwoSortedList.ListNode(3,
                        new MergeTwoSortedList.ListNode(4, null)));

        MergeTwoSortedList.ListNode expectedResult = new MergeTwoSortedList.ListNode(1,
                new MergeTwoSortedList.ListNode(1,
                        new MergeTwoSortedList.ListNode(2,
                                new MergeTwoSortedList.ListNode(3,
                                        new MergeTwoSortedList.ListNode(4,
                                                new MergeTwoSortedList.ListNode(4))))));


        MergeTwoSortedList.ListNode actual = mergeTwoSortedList.mergeTwoLists(l1, l2);

        assertEquals(expectedResult, actual);
    }

}