class MedianFinder {
    
    // 除了以下的方法，如果有一种能够随时maintain一种insert后还平衡的、并且可以index(以取出中位数)的结构是最好的
    // 也就是说，如果priorityQueue是支持indexing的就好了
    
//     // 法一：✅ 3.03% 每次找中位数的时候把数组sort一遍，然后取中间的两位
//     // 复杂度：O(nlog(n))
//     /** initialize your data structure here. */
//     List<Integer> list;
//     public MedianFinder() {
//         this.list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int size = list.size();
//         return size==0 ? 0 : (size%2==0 ?  (list.get(size/2-1) + list.get(size/2))/2.0 : list.get(size/2) );
//     }
    
    // 法二：✅ 4.91%
    // 2 priorityQueue, 一个min heap（用来放最大的一半）。一个max heap（用来放最小的一半）
    // 复杂度：O(log(n))
    /** initialize your data structure here. */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int sizemaxH = maxHeap.size();
        int sizeminH = minHeap.size();
        int sizeSum = sizemaxH + sizeminH;
        System.out.println(sizemaxH + " " + sizeminH);
        return sizeSum==0 ? 0 : (sizeSum%2==0 ? (maxHeap.peek() + minHeap.peek())/2.0 : maxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
