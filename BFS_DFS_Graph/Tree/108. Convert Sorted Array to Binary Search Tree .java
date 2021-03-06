/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

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
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){ // 加了这个以后从43% -> 100%
            return null;
        }
		return dfs(0, nums.length, nums);
    }
	
	// s is the inclusive start index of nums
	// e is the exclusive end index of nums
	public TreeNode dfs(int s, int e, int[] nums) {
		if(s>=e) {
			return null;
		}
		int mid = (e+s)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(s, mid, nums);
		root.right = dfs(mid+1, e, nums);
		return root;
	}
}