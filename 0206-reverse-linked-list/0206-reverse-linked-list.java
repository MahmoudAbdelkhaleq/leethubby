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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null) return head;
        if(head.next.next == null){
            ListNode second = head.next;
            head.next = null;
            second.next = head;
            return second;
        }
        ListNode reversed = reverseList(head.next);
        head.next = null;
        ListNode current = reversed.next;
        while(current.next!=null) current = current.next;
        current.next = head;
        return reversed;
    }
}