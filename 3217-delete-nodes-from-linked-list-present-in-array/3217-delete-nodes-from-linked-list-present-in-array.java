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
        ListNode prev = null;
        while(current!=null){
            if(set.contains(current.val)){
                if(current == head){
                    current = current.next;
                    head = current;
                }
                else{
                    prev.next = current.next;
                    current = prev.next;
                }
            }
            else{
                prev = current;
                current=current.next;
            }
        }
        return head;
    }
}