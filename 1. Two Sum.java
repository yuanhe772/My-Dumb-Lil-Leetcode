/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a new array:int a[]=new int[10];
        int[] r=new int[2];
        int i=0, j=0;
        //inside of for-loop, the first element in parenthesis has to be an expression
        for(i=0;i<nums.length;i++){// arrays: array.length, String: string.length()
            for(j=i+1;j<nums.length;j++){//cannot use i++!(it will increment i after assigned the value)
                //cannot use ++i(it will change the value of i)
                //can only use i+1!!! Because it wont change the value of i
                if(nums[i]+nums[j]==target){
                    r[0]=i;
                    r[1]=j;
                    return r;}
            }
        }
        
        return r;//the return statement has to be there!!!
    }
}
