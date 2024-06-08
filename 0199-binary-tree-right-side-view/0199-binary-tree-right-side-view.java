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
    List<Integer> list = new ArrayList<>();
    int maxLevel = Integer.MIN_VALUE;
    public List<Integer> rightSideView(TreeNode root) {
        util(root, 0);
    return list;
}

public void util(TreeNode root, int level) {
        if(root==null) return ;
        
        if(level > maxLevel){
            list.add(root.val);
            maxLevel = level;

        }
    
        if(root.right!=null){
            util(root.right,level + 1);
        }
        if(root.left!=null){
            util(root.left, level + 1);
        }
        
    }
}