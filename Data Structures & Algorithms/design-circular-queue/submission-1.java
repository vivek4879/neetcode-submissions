class MyCircularQueue {
    int[] queue;
    int curEles;
    int k;
    int front;
    int rear;
    public MyCircularQueue(int k) {
        queue = new int[k];
        this.k = k;
        curEles = 0;
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(curEles == k)return false;
        rear = (rear+1)%k;
        if(curEles == 0){
            front = rear;
        }
        queue[rear] = value;
        curEles++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(curEles == 0)return false;
        curEles--;
        front = (front+1)% k;
        return true;
    }
    
    public int Front() {
        if(curEles ==0)return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(curEles == 0)return -1;
        return queue[rear];

        
    }
    
    public boolean isEmpty() {
        return (curEles ==0);
    }
    
    public boolean isFull() {
        return (curEles == k);
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
