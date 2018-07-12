
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m+n-1; int u = m-1; int v = n-1;
//         法一：不用自增自减运算符
//         while (u>=0 && v>=0){
//             if(nums1[u]>=nums2[v]){
//                 nums1[i] = nums1[u];
//                 i--;
//                 u--;
//             }
//             else{
//                 nums1[i] = nums2[v];
//                 i--;
//                 v--;
//             }
//         }
        
//         while(v>=0){
//             nums1[i] = nums2[v];
//             i--;
//             v--;
//         }
        
        
//         法二：用自增自减运算符
        // 用整数自减，和三元运算符，更简洁：
        while(u>=0 && v>=0 && i>=0){
            nums1[i--] = nums1[u]>=nums2[v] ? nums1[u--] : nums2[v--]; 
        }
        
        // 因为第一个array更长，如果存在 【4，5，6，0，0】和【1，2】的情况，那第一个while走完以后，第二个while里的东西就没merge进去
        // 所以需要第二个while
        while(v>=0){
            nums1[i--] = nums2[v--];
        }
    }
}
