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
    public ListNode reverseKGroup(ListNode head, int k) {
        int curLen = 0;
        ListNode cur = head;
        ListNode dummy = new ListNode();
        ListNode lastTail = dummy;
        while(cur != null){
            ListNode start = cur;
            ListNode prev = null;
            ListNode temp = cur;
            int curCount = 0;
            while(temp!=null && curCount <k){
                temp = temp.next;
                curCount++;
            }
            if(curCount == k){
                while(cur != null && curLen <k){
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                    curLen++;
                }
                lastTail.next = prev;
                lastTail = start;
                curLen = 0;
            }
            else{
                lastTail.next = cur;
                break;
            }
        }
        return dummy.next;
    }
}