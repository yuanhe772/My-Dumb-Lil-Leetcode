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
    // Iterative        95.87%
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
    
    // //Recursive     100%
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     helper(res, root);
    //     return res;
    // }
    // public void helper(ArrayList<Integer> arr, TreeNode n){
    //     if(n!=null){
    //         helper(arr, n.left);
    //         arr.add(n.val);
    //         helper(arr, n.right);
    //     }
    // }

    
    // Recursive should be improved to:
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    public void helper(ArrayList<> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.left);
    }
    
    
}
