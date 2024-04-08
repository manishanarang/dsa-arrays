/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return max;
    }

    public int maxPathSumUtil(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(maxPathSumUtil(root.left), 0);
        int rightMax = Math.max(maxPathSumUtil(root.right), 0);

        max = Math.max(max, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}