class ListNode{
    int val;
    int key;
    int freq;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val, int freq,ListNode next, ListNode prev){
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.next = next;
        this.prev = prev;
    }
}
class DoublyLinkedList{
    ListNode left;
    ListNode right;

    public DoublyLinkedList(){
        this.left = new ListNode(0,0,0,null,null);
        this.right = new ListNode(0,0,0,null,null);;
        this.left.next = right;
        this.right.prev = left;
    }
    public void remove(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(ListNode node){
        ListNode prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
}
class LFUCache {
    Map<Integer,ListNode> keyMap;
    Map<Integer,DoublyLinkedList> freqMap;
    int minFreq;
    int capacity;


    public LFUCache(int capacity) {
        minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key))return -1;
        ListNode cur= keyMap.get(key);

        DoublyLinkedList curList = freqMap.get(cur.freq);
        curList.remove(cur);
        if(cur.freq == minFreq && curList.left.next == curList.right){
            minFreq++;
        }
        int newFreq = cur.freq+1;
        cur.freq = newFreq;
        if(!freqMap.containsKey(newFreq)){
            freqMap.put(newFreq, new DoublyLinkedList());
        }
        freqMap.get(cur.freq).add(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(!keyMap.containsKey(key) && keyMap.size() ==capacity){
            DoublyLinkedList curList = freqMap.get(minFreq);
            ListNode toDel = curList.left.next;
            curList.remove(toDel);
            keyMap.remove(toDel.key);
        }
        if(keyMap.containsKey(key)){
            ListNode cur = keyMap.get(key);
            DoublyLinkedList curList = freqMap.get(cur.freq);
            curList.remove(cur);
            if(cur.freq == minFreq && curList.left.next == curList.right){
                minFreq++;
            }            
            int newFreq = cur.freq+1;
            ListNode newNode = new ListNode(key,value,newFreq,null,null);
            keyMap.put(key,newNode);
            if(!freqMap.containsKey(newFreq)){
                freqMap.put(newFreq, new DoublyLinkedList());
            }
            freqMap.get(newFreq).add(newNode);
        }
        else{
            int newFreq = 1;
            ListNode newNode = new ListNode(key,value,newFreq,null,null);
            keyMap.put(key,newNode);
            if(!freqMap.containsKey(newFreq)){
                freqMap.put(newFreq, new DoublyLinkedList());
            }
            freqMap.get(newFreq).add(newNode);
            minFreq = 1;            
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
