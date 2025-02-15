package com.example.demo.mergeksortedlist;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return new ListNode();
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
