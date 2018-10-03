/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


*/

class Solution {
    // 法一：妈的 改来改去都不work         99.02%
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        
        if(nums[0]<nums[nums.length-1])
            return BS(0, nums.length-1, target, nums);
        
        // Find pivot's index
        int pivot = findPivotIndex(0, nums.length-1, nums);
        
        // Find target in which part and BinarySearch
        if(target>=nums[pivot] && target<=nums[nums.length-1]){ // in latter part
            nums = Arrays.copyOfRange(nums, pivot, nums.length);
            int bs = BS(0, nums.length-1, target, nums);
            return bs == -1 ? -1 : bs + pivot;
        }
        else{ // in former part
            nums = Arrays.copyOfRange(nums, 0, pivot == 0 ? 1 : pivot);
            return BS(0, nums.length-1, target, nums);
        }
    }
    
    // Find Pivot's Algo could be found in https://www.youtube.com/watch?v=5BI0Rdm9Yhk
    public int findPivotIndex(int start, int end, int nums[]){ 
        int mid = (end-start)/2 + start;
        // Base Case: when mid's next < mid, then mid's next is the pivot, and should return
        if(nums[mid] > nums[mid+1]) 
            return mid+1;
        // Other Cases
        else
            if(nums[start] < nums[mid]) // meaning pivot is in mid to end
                return findPivotIndex(mid+1, end, nums);
            else // meaning pivot is in start to mid!!!!!! Have to contain the target!! so, the right must be mid, not mid - 1
                return findPivotIndex(start, mid, nums);
    }
    
    // binary search https://www.youtube.com/watch?v=atTOlifFGrg
    public int BS(int start, int end, int target, int nums[]){
        int mid = (end-start)/2 + start;
        // Base Case1: When target is completely out of range
        if(start > end){
            return -1;
        }
        // Base Case2: When mid == target, then return
        else if(nums[mid] == target){
            return mid;
        }
        else{
            // Base Case3: When target is in range but not matching any elements
            if(nums.length==1) return -1;
            else{
                if(target<nums[mid])
                    return BS(start, mid-1, target, nums);
                else
                    return BS(mid+1, end, target, nums);
            }
        }
    }
    
    // // 96.98%
    // public int search(int[] nums, int target){
    //         int l = 0, r = nums.length-1;
    //         while(l <= r)
    //         {
    //             int mid = (r - l)/2 + l;
    //             int comparator = nums[mid];
    //             // Checking if both target and nums[mid] are on same side.
    //             if((target < nums[0]) && (nums[mid] < nums[0]) || (target >= nums[0]) && (nums[mid] >= nums[0]))
    //                 comparator = nums[mid];
    //             else
    //             {
    //                 // Trying to figure out where nums[mid] is and making comparator as -INF or INF
    //                 if(target <nums[0])
    //                     comparator = Integer.MIN_VALUE;
    //                 else 
    //                     comparator = Integer.MAX_VALUE;
    //             }
    //             if(target == comparator) return mid;
    //             if(target > comparator)            
    //                 l = mid+1;            
    //             else
    //                 r = mid-1;
    //         }
    //         return -1;
    // }
}
