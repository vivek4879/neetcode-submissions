/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
       ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondStart = slow.next;
        slow.next = null;

        ListNode cur = secondStart;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode reversedHalf = prev;

        ListNode dummy = new ListNode();
        ListNode newCur = dummy;
        ListNode newHead = head;
        while(newHead!= null && reversedHalf != null){
            ListNode next = newHead.next;
            newCur.next = newHead;
            newCur = newCur.next;
            newCur.next = reversedHalf;
            newCur = newCur.next;
            reversedHalf = reversedHalf.next;
            newHead =next;
        }

        if(newHead != null){
            newCur.next = newHead;
        }
             
    }
}
