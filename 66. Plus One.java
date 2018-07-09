class Solution {
    
    // Corner Case:
    // [9] + 1 = [1, 0], instead of [10]
    // [9,9] + 1 = [1, 0, 0], instead of [9, 10]
    // [1,9,9] + 1 = [2, 0, 0], instead of [1, 9, 10]
    
//     // 法一：这种解法不适用于 [9,9] [1,9,9]
//     public int[] plusOne(int[] digits) {
        
//         if(digits[digits.length - 1]+1 != 10){
//             digits[digits.length - 1] += 1;
//             return digits;
//         }
//         else{
//             int[] res = new int[digits.length + 1];
            
//             for(int i=0; i<digits.length-1; i++){
//                 res[i] = digits[i];
//             }
//             res[digits.length-1] = 1;
//             res[digits.length] = 0;
            
//             return res;
//         }
//     }
    
    
    
    public int[] plusOne(int[] digits){
        
        for(int i = digits.length - 1; i>=0; i--){
            if(digits[i]<9){ // 为了满足小于9的就加1 和 逐步进位
                digits[i] ++;
                return digits;
            } 
            digits[i] = 0;
        }
        
        int[] res = new int[digits.length+1];
        res[0] = 1;
        
        return res;
    }
    
}
