/*

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.


*/



class Solution {
    // 从左往右看有最短距离，从右往左看也有最短距离，只要从这两个方向中选出来最小的就可以        100%
    // 如果不想brute force的话：只需要记住前一次看到的C在哪里就可以得出第i位与C的距离
    public int[] shortestToChar(String S, char C) {
        int len = S.length(), prev = -len;
        int res[] = new int[len];
        // Left to right
        for(int i=0; i<len; i++){
            if(S.charAt(i) == C)
                prev = i;
            res[i] = i-prev;
        }
        // Right to left
        for(int i=len-1; i>=0; i--){
            if(S.charAt(i) == C)
                prev = i;
            res[i] = Math.min(Math.abs(i-prev), res[i]);
        }
        return res;
    }
}
