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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        head = current.next;
        while(current!=null && current.next!=null){
            ListNode swap = current.next;
            current.next = swap.next;
            if(prev != null)
                prev.next = swap;
            swap.next = current;
            prev = current;
            current = current.next;
            
        }
        return head;
    }
}