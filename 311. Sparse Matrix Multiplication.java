/*

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |


*/



class Solution {
    
    // // 法一：✅ 就是brute force地狂算          1.87%
    // public int[][] multiply(int[][] A, int[][] B) {
    //     int[][] res = new int[A.length][B[0].length];                
    //     for(int i=0; i<res.length; i++){
    //         for(int j=0; j<res[0].length; j++){
    //             // 最内层这个循环的上界要特别小心！！不是res[0]的长度，而是A[0]的长度
    //             for(int m=0; m<A[0].length; m++){
    //                 res[i][j] += A[i][m]*B[m][j];
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    
    // // 法二： ✅  把法一里面的循环重新排序         13.51
    // public int[][] multiply(int[][] A, int[][] B) {
    //     int res[][] = new int [A.length][B[0].length];
    //     for(int i=0; i<res.length; i++){
    //         for(int m=0; m<A[0].length; m++){
    //             for(int j=0; j<res[0].length; j++){
    //                 res[i][j] += A[i][m]*B[m][j];
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    // 法三：✅     在法二的基础上，如果A[i][m] == 0的话，就跳过那个for-loop； 一次判断          95.37%
    // 与法四比较后可见：避免loop才会更快，但同等情况下，if判断比普通计算更慢
    public int[][] multiply(int[][] A, int[][] B) {
        int res[][] = new int[A.length][B[0].length];
        for(int i=0; i<res.length; i++){
            for(int m=0; m<A[0].length; m++){
                if(A[i][m]!=0){
                    for(int j=0; j<res[0].length; j++){
                        res[i][j] += A[i][m]*B[m][j];
                    }
                }
            }
        }
        return res;
    }
    
    // // 法四：✅     在法二的基础上，如果A[i][m] == 0的话，就跳过那个for-loop； 两次判断          72.03%
    // public int[][] multiply(int[][] A, int[][] B) {
    //     int res[][] = new int[A.length][B[0].length];
    //     for(int i=0; i<res.length; i++){
    //         for(int m=0; m<A[0].length; m++){
    //             if(A[i][m]!=0){
    //                 for(int j=0; j<res[0].length; j++){
    //                     if(B[m][j]!=0){
    //                         res[i][j] += A[i][m]*B[m][j];
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
}
