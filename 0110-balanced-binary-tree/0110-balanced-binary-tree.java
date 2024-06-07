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
    public boolean isBalanced(TreeNode root) {
        return util(root).isBalanced;
    }
    
    public HeightBalanced util(TreeNode root){
        if(root==null) return new HeightBalanced(true, 0);
        
        var left = util(root.left);
        var right = util(root.right);
        
        var balanced = Math.abs(left.height-right.height) <=1 &&
                        left.isBalanced && right.isBalanced;  
        
        return new HeightBalanced(balanced , 1 + Math.max(left.height,right.height));
    }

    class HeightBalanced{
        int height;
        boolean isBalanced;
        
        public HeightBalanced(boolean isBalanced, int height){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}