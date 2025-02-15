package com.example.demo.mergeksortedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MergeKSortedList {


    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(Arrays.asList(lists));
    }

    private ListNode mergeKLists(List<ListNode> lists) {

        if (lists.isEmpty()) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.getFirst();
        }
        if (lists.size() == 2) {
            return merge(lists.get(0), lists.get(1));
        }

        List<ListNode> left = lists.subList(0, lists.size() / 2);
        List<ListNode> right = lists.subList(lists.size() / 2, lists.size());

        ListNode leftResult = mergeKLists(left);
        ListNode rightResult = mergeKLists(right);

        return merge(leftResult, rightResult);
    }

    private ListNode merge(ListNode l1, ListNode l2) {


        ListNode head = null;
        ListNode tail = null;

        while (l1 != null || l2 != null) {
            ListNode actualNode;
            if (l1 == null || (l2 != null && l2.val <= l1.val)) {
                actualNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                actualNode = new ListNode(l1.val);
                l1 = l1.next;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
