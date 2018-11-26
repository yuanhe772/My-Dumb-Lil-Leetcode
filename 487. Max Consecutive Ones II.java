class Solution {
    // 想法：flip每一个1之前的0
    // 然后没有见过0（也就是前面都是1），那就flip最后一个0
    // 抄答案：76.89%
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int len=0;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            
            while(zero>1){
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
