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
        public ListNode sortList(ListNode head) {
        head = helper(head);
        return head;
    }
    private ListNode helper(ListNode node){
        if(node == null) return null;
        // split
        ListNode secondHalf = splitGetSecond(node);
        ListNode firstHalf = node;
        if(secondHalf == null) return firstHalf;
        firstHalf = helper(firstHalf);
        secondHalf = helper(secondHalf);
        // sort first and second halves
        if(firstHalf.val>secondHalf.val){
            ListNode temp = firstHalf;
            firstHalf = secondHalf;
            secondHalf = temp;
        }
        return sort(firstHalf, secondHalf);
        // return firstHalf;
    }
    private ListNode sort(ListNode first, ListNode second){
        ListNode res = new ListNode();
        ListNode curr = res;
        while(first!=null && second!=null){
            if(first.val<second.val){
                curr.next = first;
                first = first.next;
            }
            else{
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        if(first!=null) curr.next = first;
        if(second!=null) curr.next = second;
        res = res.next;
        return res;
        // ListNode current1 = first;
        // ListNode current2 = second;
        // while(current1!=null && current2!=null){
        //     if(current1.next == null && current1.val<current2.val){
        //         current1.next = current2;
        //         return;
        //     }
        //     if(current1.next!=null && current1.next.val<current2.val){
        //         current1 = current1.next;
        //     }
        //     else{
        //         ListNode next = current1.next;
        //         current1.next = current2;
        //         while (current2.next!=null && next!=null &&current2.next.val<next.val){
        //             current2 = current2.next;
        //         }
        //         ListNode temp = current2.next;
        //         current2.next = next;
        //         current1 = next;
        //         current2 = temp;
        //     }
        // }
    }
    private ListNode splitGetSecond(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
}