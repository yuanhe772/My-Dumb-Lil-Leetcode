/**

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

*/








/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case: 是2棵最最小的小🌲也就是叶子或者null
        
        /**
                    p   q
                -------------
          ||        1   0
          ||        0   1
          ||和&&    1   1     并且&&的时候已经return了，所以只存在p和q中有一个是null但是另一个不是的情况
        */
        
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // 每个recursion的最后的return基本上，都要保证自己 && next-recursion-level
        
    }
}
