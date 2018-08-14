/**

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10

*/

class Solution {
    
    
    // // 法一：✅brute force, 就是找每一个bar的左界限和右界限            5.93%
    // public int largestRectangleArea(int[] heights) {
    //     int maxA = 0;
    //     for(int i=0; i<heights.length; i++){
    //         int minH = Integer.MAX_VALUE;
    //         for(int j=i; j<heights.length; j++){
    //             minH = Math.min(minH, heights[j]);
    //             maxA = Math.max(maxA, (j-i+1) * minH);
    //         }
    //     }
    //     return maxA;
    // }
}
