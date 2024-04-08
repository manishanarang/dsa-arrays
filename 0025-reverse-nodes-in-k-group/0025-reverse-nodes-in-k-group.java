/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode ptr = head;
        int i = 0;
        for(i = 0; i<k && ptr!=null ; i++){
            ptr = ptr.next;
        }
        if(i == k){ //there are atleast k nodes, then you can reverse
            int count = 0;
            ListNode curr = head;
            ListNode prev = null;
                while(curr!=null && count<k){
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev=curr;
                    curr=nextNode;
                    count++;
                }
            head.next = reverseKGroup(curr, k);
            return prev;
        } 
        return head;
        
    }

}