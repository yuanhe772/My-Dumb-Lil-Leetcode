/**

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
    // Zingbox 3rd Interview：
    
    // 法一： Iterative:                           86.29%
    // 因为是BFS， 所以通常想到用一个queue来辅助
    // 然后每一层：把本层元素放进去，依次把本层的孩子放进去，然后把本层都poll出来
    // keep track of 每一层的方法就是：在每个循环开始前keep一个nodes-number-of-this-level
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        // 要注意这里List的用法哦！这里的return必须得是List<List<Integer>>型的，不可以是ArrayList<ArrayList<Integer>>型的
        // 并且定义的时候：可以是List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 可以是：List<List<Integer>> res = new ArrayList<>();
        // 不可以是：List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty()){ // 或者 while(q.size()!=0)
            int numOfNode = q.size();
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for(int i=0; i<numOfNode; i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                sub.add(q.poll().val);
            }
            res.add(sub);
        }
        return res;
    }
}
