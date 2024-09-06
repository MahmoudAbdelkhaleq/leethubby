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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        ListNode current = head;
        // check each element but the first one
        while(current.next!=null){
            if(set.contains(current.next.val)){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        // check the first one
        if(set.contains(head.val)){
            head = head.next;
        }
        return head;
    }
}