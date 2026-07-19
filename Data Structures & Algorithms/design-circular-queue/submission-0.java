class ListNode{
    int value;
    ListNode next;

    ListNode(int val){
        this.value = val;
    }
}
class MyCircularQueue {
    ListNode dummy;
    ListNode head;
    ListNode tail;
    int curLen;
    int maxLen;
    public MyCircularQueue(int k) {
        dummy = new ListNode(0);
        curLen = 0;
        maxLen = k;
        head = dummy;
        tail = dummy;
    }
    
    public boolean enQueue(int value) {
        if(curLen == maxLen)return false;
        tail.next = new ListNode(value);       
        tail = tail.next;
        if(curLen == 0){
            head = tail;
        }
        curLen++;
        return true;

    }
    
    public boolean deQueue() {
        if(curLen == 0)return false;
        curLen--;
        dummy.next = head.next;
        head = head.next;
        return true;
    }
    
    public int Front() {
        if(curLen == 0)return -1;
        return head.value;
    }
    
    public int Rear() {
        if(curLen == 0)return -1;
        return tail.value;
    }
    
    public boolean isEmpty() {
        return(curLen == 0);
    }
    
    public boolean isFull() {
        return (curLen == maxLen);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

