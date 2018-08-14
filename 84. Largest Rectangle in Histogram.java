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
    
    // // 法二：✅Divide and Conquer, 因为一个最大矩形的面积其实是由某一些连续bar的最低值影响的，所以分别一点一点divide
    // // 要特别注意DAC方法中的左边界和右边界，以及停止条件应该为left>right等，而不应该是其他sb的if(arr.length == 1 | 0)之类的
    // // 11.38%
    // public int largestRectangleArea(int[] heights) {
    //     return maxArea(heights, 0, heights.length-1);
    // }
    // public int maxArea(int[] arr, int left, int right){
    //     if(left>right) return 0;
    //     /* int[] bar = {0, Integer.MAX_VALUE}; 
    //     这种情况下 [0,0,0,Integer.MAX_VALUE]就会疯狂的stackoverflow，因为在for里面的判断条件是，
    //     如果当前值小于最小值（初设为Integer.MAX_VALUE），则替换，并且记录此时的min值得index，但是这样导致的问题是
    //     永远都记录不到Integer.MAX_VALUE的index值
    //     为了避免这个问题，可以采用第一位为最小值的方法，然后往后比较*/
    //     int minBar = left;
    //     /* for(int i=0; i<arr.length; i++){ 这句的问题！！！边界根本就不对啊！！*/
    //     for(int i=left; i<right+1; i++){
    //         if(arr[i] < arr[minBar]) minBar = i;
    //     }     
    //     /* 一开始这一句也有问题！！两个sub-recursion的分别的左边界和右边界应该是left和right而不是0和arr.length-1！！！*/
    //     return Math.max((right-left+1)*arr[minBar], Math.max(maxArea(arr, left, minBar-1), maxArea(arr, minBar+1, right)));
    // }
    
    
    // 法三：❌Divide and Conquer，我最初的想法，但是会stackoverflow
    public int largestRectangleArea(int[] heights) {
        return maxArea(heights, 0, heights.length-1);
    }
    public int maxArea(int[] arr, int left, int right){        
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        int minIndex = left;
        for(int i=left; i<right+1; i++){
            if(arr[i] < arr[minIndex]) minIndex = i;
        }     
        return Math.max((right-left+1)*arr[minIndex], Math.max(maxArea(arr, left, minIndex==0?0:minIndex-1), maxArea(arr, minIndex==(arr.length-1)?minIndex:minIndex+1, right)));
    }
}
