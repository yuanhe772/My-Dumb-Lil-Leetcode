/**

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/



class Solution {
    // // 法一：✅，首先取XOR，得到一个二进制数，里面的1就是不一样的bits，然后数出一共有多少个1
    // // 67%
    // public int hammingDistance(int x, int y) {
    //     String xor = Integer.toBinaryString(x^y);
    //     int count = xor.replace("0","").length();
    //     return count;
    // }
    
    // 法二：直接用Integer.bitCount()就能数出这个整数化成二进制后里面有多少的1
    // 99.92
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
