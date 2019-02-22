/*


Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3


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



/*

总结：遇到这种tree的题目：一定要注意!!!!!❗️❗️❗️❗️❗️❗️❗️

如果题目条件是走完一个完整的path 才返回的话: 
    那就需要make sure它的base case是root!=null && root.left==null && root.right==null
    
如果题目的条件是走任何不完整也行的path的话：
    那就只需要make sure它的base case是root == null就可以了

*/





class Solution {
//     // 法一：❌recursive & DFS
//     // 这种方法里面 [1,2,3,null,5]
//     /*
//            1
//          /   \
//         2     3
//          \
//           5
//     */
//     // 得到 ["12","125","125","13","13"]
//     // 因为下面这种方法是 只要见到null就返回，也就是说，一条完整的路径没有走完，而是从null分支跑出去了
//     public List<String> binaryTreePaths(TreeNode root) {
//         if(root == null) {
//             return null;
//         }
//         List<String> ret = new ArrayList<>();
//         dfs(ret, root, "");
//         return ret;
//     }
    
//     public void dfs(List<String> ret, TreeNode root, String path) {
//         if(root == null) {
//             ret.add(path);
//             return;
//         }
//         path += root.val;
//         String pathTem = path;
//         dfs(ret, root.left, path);
//         dfs(ret, root.right, pathTem);
        
//     }
    
    
    // 法二：✅继续改对以上的方法 recursive & DFS
    // 这种方法里面 [1,2,3,null,5]
    /*
           1
         /   \
        2     3
         \
          5
    */
    // 得到 ["12","125","125","13","13"]
    // 因为下面这种方法是 只要见到null就返回，也就是说，一条完整的路径没有走完，而是从null分支跑出去了
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        dfs(ret, root, "");
        return ret;
    }
    
    public void dfs(List<String> ret, TreeNode root, String path) {
        if(root != null) {
            path += root.val;
            if(root.left == null && root.right == null) {
                ret.add(path);
                return;
            } else {
                path += "->";
            }
            // Backtracking：因为从left弹回来以后，要没有left的结果影响
            String pathTem = path;
            dfs(ret, root.left, path);
            dfs(ret, root.right, pathTem);
        }
    }
}