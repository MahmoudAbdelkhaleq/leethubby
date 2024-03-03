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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int steps = 0;
        ListNode c1 = head;
        ListNode c2 = head;
        ListNode prev = null;
        while(c1!=null){
            if(steps < n)
                steps++;
            else{
                prev = c2;
                c2 = c2.next;
            }
            c1 = c1.next;
        }
        if(prev == null) return head.next;
        prev.next = c2.next;
        return head;
    }
}