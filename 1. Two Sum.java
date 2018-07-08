/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.*/



class Solution {
    // 法一：O（n^2）Brute Force
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=0; i<nums.length-1; i++){
//             for(int j=i+1; j<nums.length; j++){ // has to be i+1 to avoid using the same element twice, e.g. [3,2,4] target == 6, 
//                 if(nums[i]+nums[j] == target){
//                     int[] res = {i,j};
//                     return res;
//                 }
//             }
//         }
        
//         int[] res = new int[0];
//         return res;
//     }
    
    // 法二：O（n）HashMap
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(map.get(target - nums[i]) != null){
                int[] res = {i, map.get(target-nums[i])};
                return res;
            }
            map.put(nums[i], i);
        }
        
        
        int[] res = new int[0];
        return res;
        
    }
}
