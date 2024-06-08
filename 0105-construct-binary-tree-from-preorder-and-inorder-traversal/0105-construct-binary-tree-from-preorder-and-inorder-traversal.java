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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return util(preorder, inorder, 0, inorder.length-1);
    }
    
    TreeNode util(int[]preorder, int[] inorder, int low, int high){
        if(low>high ) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = search(inorder,root.val);
        root.left = util(preorder, inorder, low, index-1);
        root.right = util(preorder, inorder, index+1, high);
        
        return root;
    }
    
    public int search(int[] inorder, int key){
        for(int i = 0; i<inorder.length;i++){
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }
}