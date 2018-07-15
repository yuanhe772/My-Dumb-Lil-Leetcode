class Solution {
    // 法一：✅对比reverse，知识点：SB.reverse()不是idempotent的，也就是说一次调用reverse后，SB就变成那个reverse值了而不是return一个新reverse
    //      同时学会了两个函数：Character.isLetterOrDigit(xx)，和 s1.equalsIngnoreCase(s2)          93.81%
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return (sb.toString()).equalsIgnoreCase(sb.reverse().toString());
    }
    
    
    // // 法二：✅recursive：首先对String预处理，其次用recursive的方式判断是否palindrome             1.57%
    // public boolean isPalindrome(String s){
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0; i<s.length(); i++){
    //         if(Character.isLetterOrDigit(s.charAt(i))){
    //             sb.append(s.charAt(i));
    //         }
    //     }
    //     String trans = sb.toString().toLowerCase();
    //     return isPal(trans);
    // }
    // public boolean isPal(String s){
    //     if(s.length() <= 1) return true;
    //     int n = s.length()-1;
    //     return s.charAt(0) == s.charAt(n) && isPal(s.substring(1,n));
    // }
}
