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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode leftEnd = dummy;
        int l = 1;
        while(cur!= null && l < left){
            l++;
            leftEnd = cur;
            cur = cur.next;
        }

        ListNode prev = null;
        ListNode end = cur;
        while(cur != null && l <right+1){
            l++;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        leftEnd.next = prev;
        end.next = cur;
        return dummy.next;        
    }
}