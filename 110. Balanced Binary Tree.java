/**
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
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
    boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) 
            return balance;
        int hah = maxH(root);
        return balance;
    }
    
    public int maxH(TreeNode T) {
        if(T == null)
            return 0;
        
        // 要特别注意【1，2】的情况！
        // 还有【1，null, 2, null, 3】的情况！
        int l = maxH(T.left);
        int r = maxH(T.right);
        
        if(Math.abs(l-r)>1) 
            balance = false;
        
        System.out.println(1+Math.max(l,r));
        return 1 + Math.max(l,r);
        // 小心三元运算符中括号的位置
        // return 1 + (l>r? l : r);
    }
}
