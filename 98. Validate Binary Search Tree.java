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
//     /** 以下注释解法不适合这种情况
//           10
//          /  \
//         4    11
//             /  \
//            3    12
//     */
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) 
//             return true;
        
//         if(root.left == null && root.right == null) 
//             return true;
        
//         if(root.left == null && root.right != null) 
//             return root.val < root.right.val ? true: false && isValidBST(root.right);
        
//         if(root.right == null && root.left != null) 
//             return root.val > root.left.val ? true: false && isValidBST(root.left);
        
//         return root.left.val < root.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right);
//     }
    
    
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        int min = 0;
        boolean flag = false;
        
        while(!stack.empty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode t = stack.pop();
                if(flag){ //这个if else是为了照顾 【Integer.MIN_VALUE】的情况
                    if(t.val > min)
                        min = t.val;
                    else
                        return false;
                }
                else{
                    min = t.val;
                    flag = true;
                }
                root = t.right;
            }
        }
        
        return true;
        
    }
    
    
    
}
