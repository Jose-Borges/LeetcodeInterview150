package RandomExercises.Dailys;

import UtilityClasses.ListNode;

public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            length++;
        }

        int rotation = k % length;
        if (rotation == 0) {
            return head;
        }

        //make circular
        tail.next = head;

        int steps = length - rotation;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
