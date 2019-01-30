class Solution {
    
    // 法一：91.55% 但是space是O(N), 同时，还可以继续简化到：如果index在0，n的是palindrome，那么只需要继续判断1，n-1
    // public boolean validPalindrome(String s) {
    //     if(s.length() <= 1) return true;
    //     int end = s.length()-1;
    //     int start = 0;
    //     int flag = 0;
    //     while(start <= end){ // 适用于偶数长度 && 奇数长度
    //         if(s.charAt(start) != s.charAt(end)) {
    //             String s1 = s.substring(0,start) + s.substring(start+1, s.length());
    //             String s2 = s.substring(0,end) + s.substring(end+1, s.length());
    //             return isPal(s1) || isPal(s2);
    //         }
    //         start ++;
    //         end --;
    //     }   
    //     return true;
    // }
    // public boolean isPal(String s){
    //     int end = s.length()-1;
    //     int start = 0;
    //     while(start <= end){ // 适用于偶数长度 && 奇数长度
    //             if(s.charAt(start) != s.charAt(end)) {
    //                 return false;
    //             }
    //             start ++;
    //             end --;
    //     }
    //     return true;
    // }
    
    // 法二：Greedy（也就是按照👆header中描述了的改进版继续改的，in-place，并且只继续判断1，n-1）
    public boolean validPalindrome(String s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return isPal(s, i+1, s.length()-i) || isPal(s, i, s.length()-i-1);
            }
        }
        return true;
    }
    public boolean isPal(String s, int start, int end){
        if(s.length() < 2) return true;
        s = s.substring(start,end);
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
