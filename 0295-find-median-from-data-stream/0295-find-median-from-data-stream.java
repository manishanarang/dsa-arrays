class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            var val = maxHeap.poll();
            minHeap.add(val);
        }
        
        if(Math.abs(maxHeap.size()-minHeap.size()) > 1){
            if(maxHeap.size()>minHeap.size()){
                var val = maxHeap.poll();
                minHeap.add(val);
            }
            else{
                var val = minHeap.poll();
                maxHeap.add(val);
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        else if(maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
        
        else
            return (double)minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */