/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



*/


class Solution {
    // A Great explanation here: https://www.youtube.com/watch?v=GO5QHC_BmvM
    // 每一个element处的走法的个数都是左边走法个数+上边走法个数的和       100%
    public int uniquePaths(int m, int n) {
        int area[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i*j==0) area[i][j]=1;
                else{
                    area[i][j] = area[i-1][j]+area[i][j-1];
                }
            }
        }
        return area[m-1][n-1];
    }
}
