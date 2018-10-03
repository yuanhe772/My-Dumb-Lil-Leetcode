class Solution {
    // // 法一：Add when there are no such number in set, and remove when there are such number in set
    // //      Therefore after one loop, there are only left with the singular number.
    // public int singleNumber(int[] nums) {
    //     int one = nums[0];
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i=0; i<nums.length; i++){
    //         if(!set.add(nums[i])) set.remove(nums[i]);
    //     }
    //     for (Integer i : set) one = i;
    //     return one;
    // }
    
    // 法二：利用 XOR 的交换律，也就是Commutative，也就是无论operaters的顺序如何，结果都一样的law，也就是 A^B^C^B^A == A^A^B^B^C
    public int singleNumber(int nums[]){
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i]; 
        }
        return res;
    }
    
    // 法三：如果用的是python，那就存在list的加减法，那就可以用 2*(a+b+c) - (2*a + b + 2*c) 得到singular的元素。
    // return 2 * sum(set(nums)) - sum(nums)
}
