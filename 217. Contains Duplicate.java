class Solution {
    public boolean containsDuplicate(int[] nums) {
        //这个方法太妙了！！！
        Set<Integer> s = new HashSet<Integer>();
        
        for(int i=0; i<nums.length ; i++){
            
            if (!s.add(nums[i]))
            {return true;}
            
        }
        
        // 或者可以用iterator和iterable去遍历nums中的每一个元素
        
        return false;
        
    }
}
