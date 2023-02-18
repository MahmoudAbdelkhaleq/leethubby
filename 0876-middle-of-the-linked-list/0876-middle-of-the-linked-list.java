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
    public ListNode middleNode(ListNode head) {
        if(head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null)
                return slow;
        }
        return slow;
    }
}