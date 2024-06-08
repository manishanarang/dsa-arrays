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
    
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return util(root,Integer.MIN_VALUE);
    }
    public int util(TreeNode root, int maxValue){
        if(root == null){
            return 0;
        }
        int result = 0;
        if(root.val >= maxValue){
            maxValue = root.val;
            result = 1;
        }
        
        return result + util(root.left, maxValue) + util(root.right, maxValue);
        
    }
}