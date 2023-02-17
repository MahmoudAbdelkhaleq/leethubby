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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = new ListNode();
        ListNode pointer = result;
        while(list1!=null && list2!=null){
            int val=0;
            if(list1.val<=list2.val){
                val=list1.val;
                list1=list1.next;
            }
            else{
                val=list2.val;
                list2=list2.next;
            }
            pointer.val = val;
            if(list1 != null && list2 != null){
                pointer.next = new ListNode();
                pointer=pointer.next;
            }
        }
        if(list1==null && list2!=null){
            pointer.next= list2;
        }
        if(list1!=null && list2 == null){
            pointer.next = list1;
        }
        return result;
    }
}