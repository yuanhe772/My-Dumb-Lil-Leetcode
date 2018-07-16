class Solution {
    // 看discussion，貌似很神奇的一点是：如果是happy num，那最后会是1，如果不是happy num，那最后会跟set里的值重复
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while(sum != 1 && set.add(sum)){ // 啊啊啊啊啊啊啊！再一次因为&&被写成||被坑！！！写成||会无限循环的呀！！！！
            sum = 0;
            while(n != 0){
                sum += (n%10) * (n%10);
                n /= 10;
            }
            n = sum;
        }
        if(sum == 1) return true;
        return false;
    }
}
