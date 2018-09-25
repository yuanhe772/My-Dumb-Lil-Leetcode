/*

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:



*/


class Solution {
    // 97.48%
    public int islandPerimeter(int[][] grid) {
        int lands = 0;
        int neighbors = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    lands++;
                    neighbors += numOfNeighbors(grid, i, j);
                }
            }
        }
        return lands*4 - neighbors;
    }
    public int numOfNeighbors(int[][] grid, int x, int y){
        int res = 0;
        if(x > 0 && grid[x-1][y]==1) res++;
        if(x < grid.length-1 && grid[x+1][y]==1) res++;
        if(y > 0 && grid[x][y-1]==1) res++;
        if(y < grid[0].length-1 && grid[x][y+1]==1) res++;
        return res;
    }
}
