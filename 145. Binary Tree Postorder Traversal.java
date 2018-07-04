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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        
        while(!stack.empty() || root!=null){
            if(root!=null){
                res.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            else{
                TreeNode t = stack.pop();
                root = t.left;
            }
        }
        
        return res;
    }
    
    
}
