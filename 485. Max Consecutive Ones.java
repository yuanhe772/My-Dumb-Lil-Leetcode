class Solution {
    // 法一：直接一个counter   100%
    // public int findMaxConsecutiveOnes(int[] nums) {
    //     int count = 0;
    //     int max = count;
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] == 1) count ++;
    //         else {
    //             max = Math.max(max, count);
    //             count = 0;
    //         }
    //     }
    //     return Math.max(max, count);
    // }
    
    // 法二：2 pointer
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int len=0;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            
            while(zero>0){
                if(nums[j]==0){
                    zero--;
                }
                j++;
            }
            len=Math.max(i-j+1,len);
        }
        
        return len;
    }
}
