package com.example.demo.swapnodesinpairs;

import java.util.Objects;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode iterator = head;

        ListNode past = null;
        ListNode pastPast = null; // To reconnect previous node to the swapped 1 (past past) --> 4 (iterator) --> 3 (past)
        boolean isMomentToChange = false;
        boolean changedHead = false;

        while (iterator != null) {

            if (isMomentToChange) {
                if(pastPast != null){
                    pastPast.next = iterator;
                }
                ListNode next = iterator.next;
                iterator.next = past;
                past.next = next;

                if(!changedHead) {
                    head = iterator;
                    changedHead = true;
                }

                iterator = iterator.next;
                pastPast = iterator;

                isMomentToChange = false;

            } else {
                past = iterator;
                isMomentToChange = true;
            }
            iterator = iterator == null ? null : iterator.next;
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


