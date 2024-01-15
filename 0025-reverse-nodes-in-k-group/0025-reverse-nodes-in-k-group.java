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
        ListNode start = head;
        ListNode before = head;
        ListNode end = head;
        while (end!=null){
            for(int i = 0;i<k-1 && end!=null;i++){
                end = end.next;
            }
            if(end == null) break;
            ListNode next = end.next;
            end.next = null;
            if(start!=before) {
                before.next = null;
            }
            else head = end;
            ListNode reversed = reverse(start);
            if(start!=before) before.next = reversed;
            while (reversed.next!=null){
                reversed = reversed.next;
            }
            reversed.next = next;
            start = next;
            before = reversed;
            end = start;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}