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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode second = null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode first = dummy.next;
        
        int curLen = 0;
        boolean flag = false;

        while(first != null){
            curLen++;
            first = first.next;
            if(flag){
                prev = second;
                second = second.next;
            }
            if(curLen == n){
                flag = true;
                second = head;
            }
        }
        prev.next = second.next;
        return dummy.next;
    }
}
