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
    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while(current!=null){
            while(!stack.isEmpty() && current.val>stack.peek()){
                stack.pop();
            }
            stack.push(current.val);
            current = current.next;
        }
        ListNode res = null; 
        while(!stack.isEmpty()){
            ListNode node = new ListNode(stack.pop());
            node.next = res;
            res = node;
        }
        return res;
    }
}