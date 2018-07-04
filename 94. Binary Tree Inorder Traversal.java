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
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
        
        When
              1
             / \
            /   \
          null  null
          
        Then the left null pops node 1, the right null pops the parent node of node 1.
        
        */
        
        
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!stack.empty() || root!=null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode t = stack.pop();
                res.add(t.val);
                root = t.right;
            }
        }
        
        return res;
        
    }
}
