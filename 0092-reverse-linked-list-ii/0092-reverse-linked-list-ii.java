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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        int index = 1;
        ListNode prev = null;
        while(index!=left){
            if(index == left-1)prev = current;
            current = current.next;
            index++;
        }
        ListNode start = current;
        while(index!=right){
            current = current.next;
            index++;
        }
        ListNode end = current;
        ListNode next = current.next;
        end.next = null;
        
        if(prev!=null) prev.next = reverse(start);
        else head = reverse(start);
        current = head;
        while(current.next!=null)current = current.next;
        current.next = next;
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}