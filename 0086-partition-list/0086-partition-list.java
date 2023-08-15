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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if(head.next == null) return head;
//         ListNode prevLess;
//         if(head.val<x) prevLess = head;
//         else prevLess = null;
//         ListNode current = head.next;
//         ListNode prev = head;
//         while(current.next!=null){
//             if(current.val>=x){
//                 current = current.next;
//                 prev = prev.next;
//             }
//             else{
//                 if(prev == null){
//                     ListNode tmp = current.next;
//                     current.next = prevLess;
//                     prev.next = tmp;
                    
//                     current = tmp;
//                     head = 
//                 }
//             }
//         }
        ListNode current = head;
        ListNode res = null;
        ListNode resCurrent = null;
        while(current!=null){
            if(current.val<x){
                if(res == null) {
                    res = new ListNode(current.val);
                    resCurrent = res;
                }
                else {
                    resCurrent.next = new ListNode(current.val);
                    resCurrent = resCurrent.next;
                }
            }
            current = current.next;
        }
        current = head;
        while(current!=null){
            if(current.val>=x){
                if(res == null) {
                    res = new ListNode(current.val);
                    resCurrent = res;
                }
                else {
                    resCurrent.next = new ListNode(current.val);
                    resCurrent = resCurrent.next;
                }
            }
            current = current.next;
        }
        return res;
    }
}