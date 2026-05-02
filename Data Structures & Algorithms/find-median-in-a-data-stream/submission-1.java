class MedianFinder {
    List<Integer> stream;
    public MedianFinder() {
        stream = new ArrayList<>();
    }
    
    public void addNum(int num) {
        stream.add(num);
        Collections.sort(stream);
    }
    
    public double findMedian() {
        int len = stream.size();
        int mid = len/2;
        if(len %2 == 0){
            return (double)(stream.get(mid)+stream.get(mid-1))/2;
        }
        else{
            return (double) stream.get(mid);
        }
    }
}
