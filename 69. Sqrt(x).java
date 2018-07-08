/**


Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.


*/


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
