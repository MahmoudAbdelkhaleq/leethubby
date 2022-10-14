/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if (head.next==null) return null;
        
        ArrayList <ListNode> soFar = new ArrayList<ListNode>(); 
        while(true){
            if(soFar.contains(head)){
                return head;
            }
            else{
                if(head.next==null) return null;
                else {
                    soFar.add(head);
                    head = head.next;
                }
            }
        }
    }
}