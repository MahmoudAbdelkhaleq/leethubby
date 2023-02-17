/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        ArrayList<ListNode> data = new ArrayList<ListNode>();
        while(current!=null){
            if(data.contains(current)) return true;
            data.add(current);
            current = current.next;
        }
        return false;
    }
}