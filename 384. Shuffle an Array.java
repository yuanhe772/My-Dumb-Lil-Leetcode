/**

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

*/


class Solution {
    
//     //法一： 类似于380，   Brute Force       56%
    
//     int[] original;
//     List<Integer> shuffle;
    
//     public Solution(int[] nums) {
//         original = nums;
//         shuffle = convert(nums);
//     }
    
//     /** Resets the array to its original configuration and return it. */
//     public int[] reset() {
//         return original;
//     }
    
//     /** Returns a random shuffling of the array. */
//     public int[] shuffle() {
//         java.util.Random rand = new java.util.Random();
//         int res[] = new int[original.length];
//         for(int i=0; i<res.length; i++){
//             int randomIndex = rand.nextInt(shuffle.size());
//             res[i] = shuffle.get(randomIndex);
//             shuffle.remove(randomIndex);
//         }
//         // shuffle = original in the end
//         shuffle = convert(original);
//         return res;
//     }
    
//     public List<Integer> convert(int[] arr){
//         List<Integer> res = new ArrayList<>();
//         for(int i : arr){
//             res.add(i);
//         }
//         return res;
//     }
    
    
//     //法一.1： 类似于380，   Brute Force   改进了多出一个List<Integer> shuffle的情况    78%
    
//     int[] original;
    
//     public Solution(int[] nums) {
//         original = nums;
//     }
    
//     /** Resets the array to its original configuration and return it. */
//     public int[] reset() {
//         return original;
//     }
    
//     /** Returns a random shuffling of the array. */
//     public int[] shuffle() {
//         java.util.Random rand = new java.util.Random();
//         int res[] = new int[original.length];
//         List<Integer> shuffle = convert(original);
//         for(int i=0; i<res.length; i++){
//             int randomIndex = rand.nextInt(shuffle.size());
//             res[i] = shuffle.get(randomIndex);
//             shuffle.remove(randomIndex);
//         }
//         return res;
//     }
    
//     public List<Integer> convert(int[] arr){
//         List<Integer> res = new ArrayList<>();
//         for(int i : arr){
//             res.add(i);
//         }
//         return res;
//     }
    
    //法二： Fisher Yates 原位操作, 对于arr的每一位来说，将本位与接下来的random某一位交换，直至所有位数都交换完         82.6%
    
    int[] original;
    
    public Solution(int[] nums) {
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int res[] = original.clone();
        java.util.Random rand = new java.util.Random();
        for(int i=0; i<res.length; i++){
            int shuffle = rand.nextInt(res.length-i) + i;
            swap(res, i, shuffle);
        }
        return res;
    }
    
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
