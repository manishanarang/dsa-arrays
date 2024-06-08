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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            int sz = queue.size(); 
            List<Integer> li = new ArrayList<>();
            
            for(int i = 0; i<sz;i++){
                var temp = queue.poll();
                li.add(temp.val);
                
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                
            }
            result.add(li);
        }
        return result;
        
    }
}