/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



*/


class Solution {
    // // A Great explanation here: https://www.youtube.com/watch?v=GO5QHC_BmvM
    // // ✅每一个element处的走法的个数都是左边走法个数+上边走法个数的和       100%
    // // 时间复杂度 O(m*n)
    // public int uniquePaths(int m, int n) {
    //     int dp[][] = new int[m][n];
    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(i*j==0) dp[i][j]=1;
    //             else{
    //                 dp[i][j] = dp[i-1][j]+dp[i][j-1];
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }
    
    // ✅：和上面方法一样的
    // 但是时间复杂度 O((m-1)*(n-1) + m + n) = O(mn+1)，因为多assign了一次(0,0)的值
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for(int i=0; i<n; i++){
            dp[0][i] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
