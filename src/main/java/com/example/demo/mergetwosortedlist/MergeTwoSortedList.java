package com.example.demo.mergetwosortedlist;

import java.util.Objects;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode tail = null;


        while (list1 != null || list2 != null) {

            ListNode actualNode = new ListNode();

            if (list2 == null || (list1 != null && list1.val <= list2.val)) {
                actualNode.val = list1.val;
                list1 = list1.next;
            } else {
                actualNode.val = list2.val;
                list2 = list2.next;
            }

            if (head == null) {
                head = actualNode;
            } else if (tail == null) {
                tail = actualNode;
                head.next = tail;
            } else {
                tail.next = actualNode;
                tail = actualNode;
            }
        }
        return head;
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

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
