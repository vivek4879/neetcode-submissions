class MedianFinder {
    PriorityQueue<Integer> pqMin;
    PriorityQueue<Integer> pqMax;
    public MedianFinder() {
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        pqMax.add(num);
        if(pqMax.size() - pqMin.size() > 1){
            int maxEl = pqMax.poll();
            pqMin.add(maxEl);
        }
        if((!pqMax.isEmpty() && !pqMin.isEmpty()) && (pqMax.peek() > pqMin.peek())){
            int left = pqMax.poll();
            int right = pqMin.poll();
            pqMin.add(left);
            pqMax.add(right);
        }

        
    }
    
    public double findMedian() {
        // System.out.println("min" + pqMin.size());
        // System.out.println("max" + pqMax.size());
        if(pqMin.size() == pqMax.size()){
            int first = pqMin.peek();
            int second = pqMax.peek();
            // System.out.println("first" + first);
            // System.out.println("second" + second);
            return (double) (first+second)/2;
        }
        else if(pqMax.size() > pqMin.size()){
            return (double) pqMax.peek();
        }
        else{
            return (double) pqMin.peek();
        }
    }
}
