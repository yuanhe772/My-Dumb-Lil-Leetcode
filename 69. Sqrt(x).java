class Solution {
    public int mySqrt(int x) {
        
        int left = 0;
        int right = x;
        int mid = 0;
        
        
        if(x < 2) return x; // Just in case that x/mid is DividedByZero
        
        
        while(left <= right){
            mid = left + (right - left)/2; // this prevents overflow
            
            if(mid > x/mid){ // compared to mid*mid > x, this prevents overflow
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return right; 
    }
}
