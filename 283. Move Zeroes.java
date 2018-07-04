Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.











class Solution {
//     // 法一：
//     // 不光要考虑只有一个0的坑，还要考虑有两个0的坑
//     public void moveZeroes(int[] nums) {
//         int l = nums.length;
//         int count = 0;
//         for(int i=0; i<l; i++){
//             if(nums[i] == 0){
//                 count ++;
//                 if(i+1<l && nums[i+1]!=0){
//                     // move
//                     for(int j = i-count+1; j<l-count; j++){
//                         nums[j] = nums[j+count];
//                     }
//                     // update zero
//                     for(int j = l-1; j >= l-count; j--){
//                         nums[j] = 0;
//                     }
//                     // reset i and count
//                     // 千万别忘了！！！要更新0和count！！！因为对于下一个0来说，还和原来的步骤一样！就不能用原来的i和count了
//                     i = 0;
//                     count = 0;
//                 }
//             }
//         }
        
//     }
//         // if (nums[0] == 0) // 这样不行！因为input = [0] 会stack overflow
//         //     moveZeroes(nums);
    
    
    // 法二：keep两个指针，一个指非0数，一个指0
    public void moveZeroes(int[] nums){
        int len = nums.length;
        
        // In case the input is [], to avoid ArrayIndexNullPointer
        if(nums == null || len == 0) return;
        
        // pointer for 0
        int j=0; 
        for(int i=0; i<len; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        
        for(j = j; j<len; j++){ // for循环括号里的第一部分必须是一个statement，比如 int i=0
            nums[j] = 0;
        }
    }
}
