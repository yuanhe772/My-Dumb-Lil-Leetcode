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
    // Recursive        97.09%
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
    
    
    // //Recursive     97.09%
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     helper(res, root);
    //     return res;
    // }
    // public void helper(ArrayList<Integer> arr, TreeNode n){
    //     if(n!=null){
    //         helper(arr, n.left);
    //         helper(arr, n.right);
    //         arr.add(n.val);
    //     }
    // }
    
    
    //Recursive2:    100%
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    // Helper should be improved to 
    public void helper(ArrayList<> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.left);
        res.add(root.val);
    }
    
    
}
