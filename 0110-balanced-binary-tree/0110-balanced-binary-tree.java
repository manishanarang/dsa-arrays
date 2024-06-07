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
        return height(root).isBalanced;
    }
    
    public HeightBalanced height(TreeNode root){
        if(root==null) return new HeightBalanced(true, 0);
        
        int lh = height(root.left).height;
        int rh = height(root.right).height;
        
        var balanced = Math.abs(lh-rh) <=1 && height(root.left).isBalanced && height(root.right).isBalanced;  
        
        return new HeightBalanced(balanced , 1 + Math.max(lh,rh));
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