/*


Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3


*/




class Solution {
    // 这道题就是说，数出一共有多少片有1的面积
    // 做法就是，看到一个1，就把它周围的1（也包括它自己）都置为0，然后数图中一共有多少个1
    
    // 法一：DFS           95.93%
    public int numIslands(char[][] grid) {
        
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);//把周围和自己都置0
                }
            }
        }
        return res;
        
    }
    
    public void dfs(char[][] grid, int r, int c){
        int height = grid.length; //就是有多少行
        int width = grid[0].length; //就是有多少列
        if(r<0 || r>=height || c<0 || c>=width || grid[r][c]=='0') return; // 碰到0就返回，没有机会继续dfs的recurse
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
