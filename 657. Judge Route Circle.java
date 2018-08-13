/**

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

*/


class Solution {
    // 法一：Time O(n) Space O(1)      49.8%
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'R') x++;
            else if(c == 'L') x--;
            else if(c == 'U') y++;
            else y--;
        }  
        return x==0 && y ==0;
    }
    
    // // 法二： Time O(n) Space O(n)，因为用到了foreach，而String貌似不是iterative的，所以只能先把String转换成Iterative的Array    80.7%
    // public boolean judgeCircle(String moves){
    //     int x = 0;
    //     int y = 0;
    //     for(char c : moves.toCharArray()){
    //     if(c == 'R') x++;
    //         else if(c == 'L') x--;
    //         else if(c == 'U') y++;
    //         else y--;
    //     }  
    //     return x==0 && y ==0;        
    // }
    
    
    // // 法三：Time O(4n) is O(n), Space O(1), 只是这种方法根本就leetcode上编译不通过
    // public boolean judgeCircle(String moves){
    //     if(moves == null || moves.length()==0) return true;
    //     return StringUtils.countMatches(moves, 'U') == StringUtils.countMatches(moves,'D') && StringUtils.countMatches(moves, 'L') == StringUtils.countMatches(moves,'R'); 
    // }

}
