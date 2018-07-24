/**

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?

*/


class Solution {
    // // 我最一开始就想到的corner case：400             100%
    // public int addDigits(int num) {
    //     if(Math.abs(num)<10) return num;
    //     int res = 0;
    //     while(Math.abs(num)>=10){
    //         res += num%10;
    //         num /= 10;
    //     }
    //     res += num;
    //     return addDigits(res);
    // }
    
    // 法二：想不通 嘻嘻            100%
    public int addDigits(int num) {
        return num==0 ? 0 : (num%9==0 ? 9 : num%9);
    }
    
    
}
