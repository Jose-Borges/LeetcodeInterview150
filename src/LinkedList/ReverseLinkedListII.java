package LinkedList;

import UtilityClasses.ListNode;

import java.util.HashMap;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> idxToVal = new HashMap<>();
        ListNode iter = head;
        int length = 1;
        for (int i = 1; iter != null; i++, iter = iter.next, length++) {
            if (i >= left && i <= right) {
                idxToVal.put(i, iter.val);
            }
        }
        iter = head;
        for (int i = 1; i <= right; i++, iter = iter.next) {
            if (i >= left) {
                iter.val = idxToVal.get(right - (i - left));
            }
        }
        return head;
    }
}
