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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot==null){
            return true;
        }
        if(root!=null && subRoot!=null){
            if(isSameTree(root, subRoot)){
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } 
        
        return false;
    }

    
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        
        if(root!=null && subRoot!=null){
            return root.val == subRoot.val &&
                    isSameTree(root.left, subRoot.left) &&
                    isSameTree(root.right, subRoot.right);
        }
        return false;
    }
}