class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    int key;
    ListNode(int key, int val, ListNode next, ListNode prev){
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    Map<Integer,ListNode> map;
    int capacity;
    ListNode left;
    ListNode right;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        left = new ListNode(0,0,null,null);
        right = new ListNode(0,0,null,left);
        left.next = right;
    }

    public void remove(ListNode cur){
        ListNode prev = cur.prev;
        ListNode next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(ListNode cur){
        ListNode prev = right.prev;
        prev.next = cur;
        cur.prev = prev;
        cur.next = right;
        right.prev = cur;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        ListNode cur = map.get(key);
        remove(cur);
        add(cur);
        return(cur.val);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        map.put(key, new ListNode(key,value,null,null));
        add(map.get(key));
        if(map.size() > capacity){
            ListNode toRemove = left.next;
            remove(toRemove);
            map.remove(toRemove.key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */