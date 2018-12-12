class Solution {
    
    // 因为要求时间复杂度不超过O(n)，并且不能用除法，所以:
    // 看到了这个神级解答：也就是：从左往右扫一遍，把一个元素前面的所有元素的乘积存下来，再从右往左扫一遍，把成绩整理后，return
//     // ✅法一：三个pass，一个从左往右，一个从右往左，一个二者两两相乘 100%
//     public int[] productExceptSelf(int[] nums) {
//         // 从左往右
//         int[] forward = new int[nums.length];
//         forward[0] = 1;
//         for(int i = 1; i < nums.length; i++){
//             forward[i] = forward[i-1] * nums[i-1];
//         }
        
//         // 从右往左
//         int[] backward = new int[nums.length];
//         backward[nums.length-1] = 1;
//         for(int i = nums.length-2; i >= 0; i--){
//             backward[i] = backward[i+1] * nums[i+1];
//         }
        
//         int[] res = new int[nums.length];
//         for(int i=0; i<nums.length; i++){
//            res[i] =  backward[i] * forward[i];
//         }
//         return res;
//     }
    
    // ✅法二：两个个pass，一个从左往右，一个从右往左并且二者两两相乘 100%
    public int[] productExceptSelf(int[] nums) {
        // 从左往右
        int[] forward = new int[nums.length];
        forward[0] = 1;
        for(int i = 1; i < nums.length; i++){
            forward[i] = forward[i-1] * nums[i-1];
        }
        // 从右往左
        int[] backward = new int[nums.length];
        int[] res = new int[nums.length];
        backward[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            backward[i] = backward[i+1] * nums[i+1];
            res[i] =  backward[i] * forward[i];
        }
        // 一定不要忘了加这一句：否则res[]的最后一位是0！！
        res[nums.length-1] = forward[nums.length-1]; // 相当于 forward[nums.length-1] * backward[nums.length-1]
        return res;
    }
}
