package com.example.demo.addTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode firstNode = null;
        ListNode actualNode = null;

        while(l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int value = l1Val + l2Val + carry;
            if(value >= 10){
                value -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(value);

            if(firstNode == null) {
                firstNode = newNode;
                actualNode = newNode;
            } else {
                actualNode.next = newNode;
                actualNode = newNode;
            }

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            actualNode.next = newNode;
        }

        return firstNode;

    }
}


