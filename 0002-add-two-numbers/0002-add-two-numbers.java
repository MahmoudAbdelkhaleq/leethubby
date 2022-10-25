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
        ListNode res = new ListNode();
        ListNode cur = res;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        boolean carry = false;
        while(cur1!=null || cur2!=null || carry){
            int sum=0;
            if(cur2==null && cur1==null){
                sum = 0;
            }
            if(cur1==null && cur2!=null){
                sum = cur2.val;
                cur2 = cur2.next;
            }
            if(cur2==null && cur1!=null){
                sum = cur1.val;
                cur1 = cur1.next;
            }
            if(cur1!=null && cur2!=null){    
                sum = cur1.val+cur2.val;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if(carry) sum++;
            if(sum >= 10){
                cur.val = sum%10;
                carry = true;
            }
            else{
                carry = false;
                cur.val =sum;
            }
            if(cur1!=null || cur2!=null || carry){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return res;
    }
}