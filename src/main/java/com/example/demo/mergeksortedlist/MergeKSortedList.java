package com.example.demo.mergeksortedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> values = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode listNode = list;
            while (listNode != null) {
                values.add(listNode.val);
                listNode = listNode.next;
            }
        }

        values = values.stream().sorted().toList();

        ListNode head = null;
        ListNode tail = null;

        for (Integer value : values) {
            ListNode actual = new ListNode(value);
            if (head == null) {
                head = actual;
            } else if (tail == null) {
                tail = actual;
                head.next = tail;
            } else {
                tail.next = actual;
                tail = actual;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
