class Solution {
    // // ❌下面这种解法对于 "   +0 123" 不work：下面这种解法：先把所有空格拿掉。然后逐位加数字
    // // 对于overflow的情况：如果已经读出的数字大于max/10了，那肯定加上本位curr会overflow，就返回max/min
    // //                   如果已经付出的数字 == max/10, 那本位数字大于max%10的话就会overflow
    // // 因为这种解法是不work的，也就是说，这道题是让解出第一个not space的char sequence
    // // 所以需要想出一种不需要str.replace(" ", "")的方法
    // public int myAtoi(String str) {
    //     str = str.replace(" ", "");
    //     if(str.length() == 0 || str.equals("") || str.charAt(0) != '-' && str.charAt(0) != '+' && !Character.isDigit(str.charAt(0))) 
    //         return 0;
    //     int sign = 1, num = 0, start = 0;
    //     if(str.charAt(0) == '-' || str.charAt(0) == '+'){
    //         sign = str.charAt(0) == '-' ? -1 : 1;
    //         start = 1;
    //     } 
    //     for(int i=start; i<str.length(); i++){
    //         char curr = str.charAt(i);
    //         if(Character.isDigit(curr)){
    //             if(num > Integer.MAX_VALUE/10 
    //                || num == Integer.MAX_VALUE/10 && (curr - '0') > Integer.MAX_VALUE%10){
    //                 num = Integer.MAX_VALUE;
    //                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    //             }
    //             num = num * 10 + curr - '0';
    //         }
    //         else break;
    //     }
    //     return sign * num;
    // }

    
    // // ❌下面这种方法又他妈的得考虑 “0-1” => 0 而不是-1的情况，也就是说，看next 位也是错误的做法
    // // 于是就应该改进成:符号只能出现在最前面，在符号以后的遍历，只能是数字+非数字，也就是数字以后的东西都忽略
    // // 也就是 “0-1” 中，-1是忽略的部分，真正读到的数字是0
    // public int myAtoi(String str) {
    //     int sign = 1, num = 0, ptr = 0;
    //     // move ptr to first non-space character
    //     while(ptr < str.length() && str.charAt(ptr) == ' '){
    //         ptr ++;
    //     }
    //     if(ptr == str.length()){
    //         return 0;
    //     }
    //     // start parsing digits
    //     for(int i=ptr; i<str.length(); i++){
    //         char curr = str.charAt(i);
    //         char next = i+1<str.length() ? str.charAt(i+1) : '+'; // next是为了 "+-2" => 0 加上的
    //         if((curr == '-' || curr == '+') && Character.isDigit(next)){
    //             sign = curr == '-' ? -1 : 1;
    //         } else if (Character.isDigit(curr)){
    //             if(num > Integer.MAX_VALUE/10 
    //                || num == Integer.MAX_VALUE/10 && (curr - '0') > Integer.MAX_VALUE%10){
    //                 num = Integer.MAX_VALUE;
    //                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    //             }
    //             num = num * 10 + curr - '0';
    //         }
    //         else break;
    //     }
    //     return sign * num;
    // }
    
    // ✅ 95%
    public int myAtoi(String str) {
        int sign = 1, num = 0, ptr = 0;
        // move ptr to first non-space character
        while(ptr < str.length() && str.charAt(ptr) == ' '){
            ptr ++;
        }
        if(ptr == str.length()){
            return 0;
        }
        if(str.charAt(ptr) == '-' || str.charAt(ptr) == '+'){
            sign = str.charAt(ptr) == '-' ? -1 : 1;
            ptr ++;
        }
        if(ptr == str.length()){
            return 0;
        }
        // start parsing digits
        for(int i=ptr; i<str.length(); i++){
            char curr = str.charAt(i);
            if (Character.isDigit(curr)){
                if(num > Integer.MAX_VALUE/10 
                   || num == Integer.MAX_VALUE/10 && (curr - '0') > Integer.MAX_VALUE%10){
                    num = Integer.MAX_VALUE;
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + curr - '0';
            }
            else break;
        }
        return sign * num;
    }
}
