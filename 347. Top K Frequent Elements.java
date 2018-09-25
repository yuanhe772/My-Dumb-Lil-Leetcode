/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/


/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/


class Solution {
    
    
//     // 法一： bucket sort，并且在最下面的那个最内层的循环中加了break后，         97%
//     // 这题一看就是bucket sort啊
//     // 首先把array中的所有元素都按照 <字母,频次> 放进map
//     // 其次把map里的东西放进bucket
//     // 最后度bucket中最靠上的几个数字
//     public List<Integer> topKFrequent(int[] nums, int k) {
        
//         // Put into Map
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//         }
        
//         // Put into Bucket
//         List<Integer> bucket[] = new ArrayList[nums.length+1];
//         for(int num: map.keySet()){
//             int freq = map.get(num);
//             if(bucket[freq] == null){
//                 bucket[freq] = new ArrayList<>();
//             }
//             bucket[freq].add(num);
//         }
        
        
//         // Put into List
//         List<Integer> res = new ArrayList<>();
//         for(int i=bucket.length-1; i>=0; i--){
//             if(bucket[i]!=null){
//                 for(int num: bucket[i]){
//                     if(k>0){
//                         res.add(num);
//                         k--;
//                         if(k == 0){
//                             break;
//                         }
//                     }
//                 }
//             }
//         }
//         return res;
//     }
    
//     // 法二：用MaxHeap          24 %, 复杂度太高了，construct a heap就得O(n^2*log(n))
//     // 也就是首先还是用Map把大家重新排列一遍
//     // 然后把Map里面的每一个值放到MaxHeap里面去
//     // 然后把MaxHeap里的东西pop出来or
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         // Put into map
//         Map<Integer, Integer> map = new HashMap<>();
//         // for(int i=0; i<nums.length; i++){
//         //     map.add(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         // }
//         // 或者也可以用iterator
//         for(int num: nums){
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }
        
//         // Put into PQ maxHeap
//         PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
//             new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
//         for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//             maxHeap.add(entry);
//         } 
        
//         List<Integer> res = new ArrayList<>();
//         while(k>0){
//             Map.Entry<Integer, Integer> entry = maxHeap.poll();
//             res.add(entry.getKey());
//             k--;
//         }
        
//         return res;
//     }
    
    // 法三：用MinHeap       时间复杂度可能更高，但是比maxHeap的heap size要小       23.07%
    public List<Integer> topKFrequent(int[] nums, int k) {
        // put into map
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // put into PQ
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                // minHeap.pop();
                minHeap.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(k>0){
            // Map.Entry<Integer, Integer> entry = minHeap.pop();
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.add(entry.getKey());
            k--;
        }
        return res;
    }
    
}
