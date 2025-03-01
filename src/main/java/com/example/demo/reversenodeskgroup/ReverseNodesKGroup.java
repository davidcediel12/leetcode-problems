package com.example.demo.reversenodeskgroup;


import java.util.Objects;

public class ReverseNodesKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1){
            return head;
        }
        ListNode iterator = head;

        ListNode past = null;
        ListNode pastPast = null; // To reconnect previous node to the swapped 1 (past past) --> 4 (iterator) --> 3 (past)
        ListNode nodeToSwap = null;


        int i = 1;
        boolean isMomentToChange;
        boolean changedHead = false;

        while (iterator != null) {

            isMomentToChange = i == k;

            if (isMomentToChange) {
                if (pastPast != null) {
                    pastPast.next = iterator;
                }

                ListNode next = iterator.next;

                if (k == 2) {
                    iterator.next = past;
                    past.next = next;
                } else {
                    past.next = nodeToSwap;
                    iterator.next = nodeToSwap.next;
                    nodeToSwap.next = next;
                }

                if (!changedHead) {
                    head = iterator;
                    changedHead = true;
                }

                while(i > 1){
                    iterator = iterator.next;
                    i--;
                }
                pastPast = iterator;

                i = 0;

            } else if (i == k - 1) {
                past = iterator;
            }

            if (i == 1) {
                nodeToSwap = iterator;
            }
            iterator = iterator == null ? null : iterator.next;
            i++;
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
