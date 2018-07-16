/**

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000

*/


public class Solution {
    // you need to treat n as an unsigned value
    
    // // 法一：✅直接用Integer.bitCount()去求里面有多少为1的bits      99.77%
    // public int hammingWeight(int n) {
    //     return Integer.bitCount(n);
    // }
    
    // 法二：✅运用logic shift和bit-wise & 去求取一共有多少个1   99.77%
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count += n & 1; // 这时候&代表只与1去&最后一位，因为1只有一位
            n >>>= 1;
        }
        return count;
    }
}
