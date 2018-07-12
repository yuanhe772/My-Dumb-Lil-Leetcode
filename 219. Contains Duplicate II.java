class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        /** 哎呀 我脑残了
            题设是：看是否有 一对 的index_diff最大时候是 k，而不是确定所有的 && diff最大== k
            不过这题太jb无聊了，本人将给出leetcode一百来道题职业生涯中的第一个差评
            但是还是要通过这道题疯狂熟悉HashMap和HashSet的用法，值得的
            
            看到duplicate就应该想到hashMap或者hashTable，但是后者是线程安全的，所以有点慢，最好还是用前面那个不线程安全的比较快*/
        
        // // 法一： HashMap
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     Integer prev_index = map.put(nums[i],i); // HashMap.put() would return the existed key's value
        //     if(prev_index!=null && i-prev_index <= k) return true; // Making sure there exists duplicates where the index_diff < k
        // }
        // return false;
        
        
//         // 法二：HashSet，用set的size计数
//         Set<Integer> set = new HashSet<>();
        
//         for(int i=0; i<nums.length; i++){
            
//             if(set.contains(nums[i])){
//                 return true;
//             }
            
//             set.add(nums[i]); // 又或者 HashSet.add() 本来就有返回值，如果返回的是true，就说明之前不存在这个元素，如果返回的是false就说明之前存在这个元素
            
//             if(set.size()>k) set.remove(nums[i-k]);
//         }
        
//         return false;
        
        // 法三：HashSet，用i计数
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true; // set.add()判断的时候已经操作add了，所以就算没有进if循环也没关系，已经加进set了
        }
        
        return false;
        
    }
}
