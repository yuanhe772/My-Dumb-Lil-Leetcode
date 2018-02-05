/* Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length. */



class Solution {
    public int removeDuplicates(int[] nums) {
//         int length=nums.length;
//         for(int i=0;i<length-1;i++)
//             if(nums[i]==nums[i+1]){ 
//                 length--;
//                 for(int j=i+1; j<nums.length-1; j++){
//                     nums[j]=nums[j+1];
//             }
//                 --i;
//             }
        
        
        
//         return length;
        // The above is very slow, cauze time: O(n^2)
        
        int index=1;
        
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]!=nums[i+1]){
                nums[index++]=nums[i+1];
                //index++;
            }
        // Time O(n)
        
        
        return index;
        
        
    }
}
