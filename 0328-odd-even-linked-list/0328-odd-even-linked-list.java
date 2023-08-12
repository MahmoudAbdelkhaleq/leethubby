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
    public ListNode oddEvenList(ListNode head) {
        ListNode current = head;
        int index = 1;
        ListNode prev = head;
        while(current!=null){
            if(index % 2 == 0){
                ListNode next = current.next;
                ListNode firstEven = prev.next;
                if(next!=null){
                    prev.next = next;
                    current.next = next.next;
                    next.next = firstEven;
                    prev = next;
                    index++;
                }
            }
            current = current.next;
            index++;
        }
        return head;
    }
}