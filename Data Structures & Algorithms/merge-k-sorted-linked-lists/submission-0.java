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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        for(ListNode cur:lists){
            if(cur ==null)continue;
            pq.offer(cur);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            if(top.next!=null)pq.offer(top.next);
            cur.next = top;
            cur = cur.next;
        }
        return dummy.next;
    }
}