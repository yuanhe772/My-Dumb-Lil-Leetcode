class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//  法一： time exceeded
//         Arrays.sort(nums);
//         List<List<Integer>> res = new ArrayList<>();
//         for(int i=0; i<nums.length-2; i++){
//             if(i==0 || i>0 && nums[i]!=nums[i-1]){
//                 // System.out.println(nums[i]+"   "+nums[i+1]);
//                 for(int j=i+1; j<nums.length-1; j++){
//                     if(j==i+1 || j>i+1 && nums[j]!=nums[j-1]){
//                         for(int k = j+1; k<nums.length; k++){
//                             if(k == j+1 || k>j+1 && nums[k]!=nums[k-1]){
//                                 if(nums[i] + nums[k] + nums[j] == 0){
//                                     res.add(Arrays.asList(nums[i], nums[k], nums[j]));
//                                 }
//                             }
//                         }
//                     }  
//                 }
//             }
//         }
//         return res;
        
        
        
        
//     法二：
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++){
            if(i == 0 || i>0 && nums[i] != nums[i-1]){
                int low = i+1; // 得是i的下一位！！才能保证triple里面没有数字重复
                int high = nums.length-1;
                while(low<high){
                    if(nums[low] + nums[high] == -nums[i]){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++; // 判断条件里面，要先写low<high， 再写带【i+1】的判断条件，因为否则的话会先执行判断 nums【i+1】，which 会引发indexOutOfBound的异常
                        while(low<high && nums[high] == nums[high-1]) high --;
                        low ++;
                        high --;
                    }
                    else if(nums[low] + nums[high] < -nums[i]) low++;
                    else high--;
                }
            }
        }
        return res;
    }
}
