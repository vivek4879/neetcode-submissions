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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(l1!=null || l2!= null){
            int n1 = 0;
            int n2 = 0;
            if(l1!=null){
                n1 = l1.val;
                l1 = l1.next;
            }
            if(l2!= null){
                n2 = l2.val;
                l2 = l2.next;
            }
            int n = n1+n2 + carry;
            carry = n / 10;
            n = n % 10;
            cur.next = new ListNode(n);
            cur = cur.next;
        }

        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return dummy.next;        
    }
}
