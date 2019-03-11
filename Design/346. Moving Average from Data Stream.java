/*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/


class MovingAverage {
    
    List<Integer> l = new ArrayList<>();
    int capacity= 0;
    int size = 0;
    int sum = 0;
    int farInd = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        capacity = size;
    }
    
    public double next(int val) {
        size ++;
        if(size <= capacity) {
            l.add(val);
            sum += val;
            return (double)sum/size;
        } else {
            l.add(val);
            sum = sum - l.get(farInd) + val;
            size -- ;
            farInd += 1;
            return (double)sum/size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */