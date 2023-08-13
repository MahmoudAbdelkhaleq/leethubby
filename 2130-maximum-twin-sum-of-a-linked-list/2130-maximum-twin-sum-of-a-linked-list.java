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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow);
        int max = 0;
        while(secondHalf!=null){
            if(secondHalf.val+firstHalf.val> max)
                max = secondHalf.val + firstHalf.val;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return max;
    }
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode next = current.next;
        ListNode prev = null;
        while(next!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }
}