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
    // // Recursive        100%
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     // 相当于base case只返回空的res
    //     // recursive: 会一直recurse到null
    //     if(root!=null){
    //         res.add(root.val);
    //         res.addAll(preorderTraversal(root.left));
    //         res.addAll(preorderTraversal(root.right));
    //     }
    //     return res;
    // }
    
    
    
        // // Iterative        96.23%
        // public List<Integer> preorderTraversal(TreeNode root) {
        //     ArrayList<Integer> res = new ArrayList<Integer>();
        //     Stack<TreeNode> stack = new Stack<TreeNode>();
        //     while(!stack.empty() || root!=null){
        //         if(root!=null){
        //             stack.push(root);
        //             res.add(root.val);
        //             root = root.left;
        //         }
        //         else{
        //             TreeNode t = stack.pop();
        //             root = t.right;
        //         }
        //     }
        //     return res;   
        // }
    
//     //Recursive2    100%
//     public List<Integer> preorderTraversal(TreeNode root) {
//         ArrayList<Integer> res = new ArrayList<>();
//         helper(res, root);
//         return res;
//     }
//     public void helper(ArrayList<Integer> arr, TreeNode n){
//         if(n!=null){
//             arr.add(n.val);
//             helper(arr, n.left);
//             helper(arr, n.right);
//         }
//     }
    
    
    
     //Recursive3:    100%
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    // Helper should be improved to 
     public void helper(ArrayList<> res, TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.left);
    }
}
