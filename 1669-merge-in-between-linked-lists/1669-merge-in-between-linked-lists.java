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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        ListNode end = list1;
        for(int i = 0;i<a-1;i++){
            prev = prev.next;
        }
        for(int i = 0;i<b;i++){
            end = end.next;
        }
        ListNode current2 = list2;
        while(current2.next!=null) 
            current2 = current2.next;
        current2.next = end.next;
        prev.next = list2;
        return list1;
    }
}