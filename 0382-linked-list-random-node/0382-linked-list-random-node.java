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
    ListNode list;
    int length;
    public Solution(ListNode head) {
        list = head;
        length=0;
        ListNode current = list;
        while(current!=null){
            length++;
            current = current.next;
        }
    }
    
    public int getRandom() {
        int x = (int) (Math.random()*length);
        int i =0;
        ListNode current = list;
        while(i<x){
            current = current.next;
            i++;
        }
        return current.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */