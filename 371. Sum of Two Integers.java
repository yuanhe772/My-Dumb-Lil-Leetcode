/**

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Credits:
Special thanks to @fujiaozhu for adding this problem and creating all test cases.


*/



class Solution {
    
    // // 法一：Iterative 用 & 操作符去 keep 进位，用 ^ 异或去keep不同的位        100%
    // public int getSum(int a, int b) {
    //     if(a*b == 0) return a==0 ? b : a;
    //     // 但是这样的问题是：就不知道carry位该咋放了！！！
    //     // int carry = a & b << 1;
    //     // while(carry!=0){
    //     //     a = a ^ b;
    //     // }
    //     // return res;
    //     while(b!=0){
    //         int carry = a & b;
    //         a = a ^ b;
    //         b = carry << 1;
    //         // 这样就是让 b 一直是新的被加数，然后carry就只是辅助的
    //     } 
    //     return a;
    // }
    
    
    // 法二：recursive             100%
    public int getSum(int a, int b) {        
        // if(a*b==0) return a==0 ? b : a; // 又给忘了！乘法溢出！会提前变成0！所以返回的答案就不是0，就是-6XXXXX一个数了，就错了！
        if(a == 0) return b;
        if(b == 0) return a;
        return getSum(a^b, (a&b) << 1); // 要用括号把 （a&b）给括起来，否则的话好像先进行 b<<1 才进行的 a&b   
    }
    
    
    // // 法三：recursive              100%
    // public int getSum(int a, int b) {
    //     return b == 0 ? a : getSum(a^b);
    // }
}
