package LinkedList;

import UtilityClasses.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Handle duplicates at the beginning
        while (head != null && head.next != null && head.val == head.next.val) {
            int dup = head.val;
            while (head != null && head.val == dup) {
                head = head.next;
            }
        }

        if (head == null) return null;

        ListNode lastDistinct = head;
        ListNode iter = head.next;

        while (iter != null && iter.next != null) {

            if (iter.val == iter.next.val) {
                int dup = iter.val;

                while (iter != null && iter.val == dup) {
                    iter = iter.next;
                }

                lastDistinct.next = iter;
            } else {
                lastDistinct = lastDistinct.next;
                iter = iter.next;
            }
        }

        return head;
    }
}
