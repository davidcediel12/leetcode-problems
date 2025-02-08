package com.example.demo.removennode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveNNode {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> allNodes = new ArrayList<>();
        allNodes.add(head);

        while (head.next != null) {
            head = head.next;
            allNodes.add(head);
        }

        int indexToDelete = allNodes.size() - n;

        if (indexToDelete == 0) {
            if (allNodes.size() == 1) {
                return null;
            } else {
                return allNodes.get(1);
            }
        }

        if (indexToDelete == allNodes.size() - 1) {
            allNodes.get(allNodes.size() - 2).next = null;
            return allNodes.getFirst();
        }

        allNodes.get(indexToDelete - 1).next = allNodes.get(indexToDelete + 1);
        return allNodes.getFirst();
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
