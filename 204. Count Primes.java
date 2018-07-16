class Solution {
    // 这道题的思路好神奇：
    // 首先题目的要求是，数出n以下有多少个质数primes
    // 做法就是，创建一个长度为10的数组，每个元素对应1-n中的一个数字
    // 然后把所有的合数composite number标记出来
    // 剩下的就是质数prime number了
    
    // // 法一：❌：4XXXXX某数的时候，我这输出是4XXX4，但是标准答案是4XXXX7，也就是少了3
    // public int countPrimes(int n) {
    //     // Mark composite numbers
    //     boolean[] compo = new boolean[n];
    //     for(int i=2; i<n; i++){
    //         for(int j=i; i*j<n & i*j>i; j++){
    //             compo[i*j] = true;
    //         }
    //     }
    //     // Count prime numbers
    //     int count = 0;
    //     for(int i=2; i<n; i++){
    //         count += compo[i] ? 0:1;
    //     }
    //     return count;
    // }
    
    // // 法二：✅：改进了4XXXXX某数的时候，我这输出是4XXX4，但是标准答案是4XXXX7，也就是少了3           26%
    // // 方法是：让 j = 2
    // public int countPrimes(int n) {
    //     // Mark composite numbers
    //     boolean[] compo = new boolean[n];
    //     for(int i=2; i<n; i++){
    //         for(int j=2; i*j<n; j++){
    //             compo[i*j] = true;
    //         }
    //     }
    //     // Count prime numbers
    //     int count = 0;
    //     for(int i=2; i<n; i++){
    //         count += compo[i] ? 0:1;
    //     }
    //     return count;
    // }
    
    // 法三：✅：这样的话，在创造合数的时候就判断当前是不是质数，因为接下来创造的合数肯定比质数大，所以不要紧          25%
    public int countPrimes(int n) {
        // Mark composite numbers
        boolean[] compo = new boolean[n];
        int count = 0;
        for(int i=2; i<n; i++){
            if(compo[i] == false) count++;
            for(int j=2; i*j<n; j++){
                compo[i*j] = true;
            }
        }
        return count;
    }
}
