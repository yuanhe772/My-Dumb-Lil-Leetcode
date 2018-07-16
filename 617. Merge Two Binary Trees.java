/**

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

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
   
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 法一：❌，没有新建tree，而是在原有的tree1或tree2上加，这样不好，因为这样的话如果某个tree很小，那merge以后的结果就是不完全的
        // if(t1 == null && t2 == null) return null;
        // t1.val = t1.val + t2.val;
        // mergeTrees(t1.left, t2.left);
        // mergeTrees(t1.right, t2.right);
        // return t1;
        
        // 法二：✅87.23%，新建了tree，不光对本node有操作，还对node的左右节点有操作
        if(t1 == null && t2 == null) return null;
        int val = (t1==null ? 0:t1.val) + (t2==null ? 0:t2.val);
        TreeNode t = new TreeNode(val);
        t.left = mergeTrees(t1==null ? null : t1.left , t2==null ? null : t2.left);
        t.right = mergeTrees(t1==null ? null : t1.right , t2==null ? null : t2.right);
        return t;
    }
}
