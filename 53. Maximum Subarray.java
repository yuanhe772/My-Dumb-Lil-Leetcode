/**

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


There's a helpful tutorial for this problem:
http://theoryofprogramming.com/2016/10/21/dynamic-programming-kadanes-algorithm/
*/



class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 要考虑清楚dp[0]是啥！！
        int max = dp[0];
        
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]); 
            /**
            如果只有上面这句话：
            
            考虑 [-2,1,-3,4,-1,2,1,-5,4] 的情况，那每一步的 dp[i]：
            -2，1，-2，4，3，5，6，1，5
            也就是说，需要保证每个新加的值还要使最大值不变小
            也就是说：还要keep一个maximum值
            */
            max = Math.max(max, dp[i]); //这种时候的dp[i]就只是为了辅助max的生成
        }
        
        return max;
        
    }
}
