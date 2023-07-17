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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        fillStack(l1, stack1);
        fillStack(l2, stack2);
        int carry = 0;
        ListNode res = new ListNode();
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int sum = stack1.pop() + stack2.pop()+carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }
            else
                carry = 0;
            res = addNode(res, sum);
        }
        while(!stack1.isEmpty()){
            int sum = stack1.pop()+carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }
            else
                carry = 0;
            res = addNode(res, sum);
        }
        while(!stack2.isEmpty()){
            int sum = stack2.pop()+carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }
            else
                carry = 0;
            res = addNode(res, sum);
        }
        if(carry == 1)
            res = addNode(res,1);
        
        return res.next;
    }
    public static void fillStack(ListNode l, Stack s){
        while(l!=null){
            s.push(l.val);
            l = l.next;
        }
    }
    public static ListNode addNode(ListNode l, int sum){
        l.val = sum;
        ListNode newNode = new ListNode();
        newNode.next = l;
        return newNode;
    }
}