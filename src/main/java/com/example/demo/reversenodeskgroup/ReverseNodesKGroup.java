package com.example.demo.reversenodeskgroup;


import java.util.Objects;

public class ReverseNodesKGroup {


    public ListNode reverse(ListNode init, ListNode end) {

        ListNode past = null;
        ListNode current = init;

        while (!Objects.equals(current, end)) {

            ListNode next = current.next;

            current.next = past;
            past = current;
            current = next;
        }
        return past;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iterator = head;

        int i = 0;

        while (i < k && iterator != null) {
            iterator = iterator.next;
            i++;
        }

        if (i < k) {
            return head;
        }

        ListNode newHead = reverse(head, iterator);
        head.next = reverseKGroup(iterator, k);

        return newHead;
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
