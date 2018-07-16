/**

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false


*/


class Solution {
    // // 法一：测试是不是2的几次方，通过left shift实现power     100.0%
    // public boolean isPowerOfTwo(int n) {
    //     int i = 1;
    //     while(i>0 && i<n){ // 经过试验，这里要加个 i>0，否则的话如果n是一个超大的数，就会TLE
    //         i <<= 1; 
    //     }
    //     return i == n;
    // }
    
    // 法二：如果是2的power，那么肯定的一点是，二进制中只有一个1     100.0%
    // 然后还很interesting的一点是，对于一个只有一位是1的二进制数来说，它减一以后再跟自己&，肯定是0
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1)) == 0;
    }
}
