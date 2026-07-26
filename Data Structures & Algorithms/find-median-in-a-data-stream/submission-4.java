class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double) (((double) maxHeap.peek() + minHeap.peek())/2);
        }
        if(maxHeap.size()>minHeap.size())return maxHeap.peek();
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

