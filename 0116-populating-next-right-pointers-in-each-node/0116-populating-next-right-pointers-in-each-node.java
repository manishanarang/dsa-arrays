/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> cache = new LinkedList<>();
      
        
        if(root!=null)
            cache.add(root);
        while(!cache.isEmpty())
        {
            int count = cache.size();
            
            while(count-- > 0)
            {
                Node curr = cache.remove();
               
                  if(count > 0)
                    curr.next = cache.peek();  
               
                if(curr.left!=null)
                cache.add(curr.left);
                if(curr.right!=null)
                 cache.add(curr.right);
                
            }
          
           
        }
      
        return root;
    }
}