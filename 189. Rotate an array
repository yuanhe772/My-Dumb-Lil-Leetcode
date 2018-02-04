/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].*/



//题目的意思里面：把右面的元素挪到左边 k 次，这就说明， k不一定小于l！！


class Solution {
    public void rotate(int[] nums, int k) {
        
         //sol 3:
    int l = nums.length;
    int a[] = new int[l];
    
    for(int i=0; i<l; i++){
        a[(i+k)%l] = nums[i];
    }
    
    for(int i=0; i<l; i++){
        nums[i]=a[i];
    }
    
    return;
    
    //
        
        //Excited!!!!
        
//         int l = nums.length;
//         k = k % l; //卧槽这也太扯了。。。。。k竟然能比l大。。。我呵呵。。。。
        
//         //Sol 1:
//         // reverse(nums, 0, l-1);
//         // reverse(nums, 0, k-1);
//         // reverse(nums, k, l-1);
        
//         //Sol 2:
//         reverse(nums, 0, l-k-1);
//         reverse(nums, l-k, l-1);
//         reverse(nums, 0, l-1);
        
//         return;
    }
    
    
    // //注意！！！helper function应该写在前面那个function之后！而不是里面！
    // private void reverse(int[] nums, int s, int e){
    //         int tmp=0;
    //         while(s < e){
    //             tmp = nums[s];
    //             nums[s] = nums[e];
    //             nums[e] = tmp;
    //             s++;
    //             e--;
    //         } 
    //         return;
    //     }
    
    
   
}
