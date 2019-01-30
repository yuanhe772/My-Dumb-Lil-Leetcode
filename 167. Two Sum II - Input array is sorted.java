// 亲爱的yuanhe772账号 好久不见呀
// I feel super grateful right now, 开心，嘻嘻，dont forget about how grateful u've been for life, for friends, for everything u possess now

class Solution {
    // 因为是sorted array，所以应该想到要用双指针扫一遍解决
    // 虽然用HashMap也是只扫一遍，但是需要用到extra data structure
    public int[] twoSum(int[] nums, int target) {
        int head = 0, tail = nums.length-1;
        while(head<tail) {
            int sum = nums[head] + nums[tail];
            if(sum == target) return new int[]{++head, ++tail};
            if(sum < target) head ++;
            if(sum > target) tail --;
        }
        return null;
    }
}
