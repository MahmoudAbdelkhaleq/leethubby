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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] res = new ListNode[k];
        ListNode current = head;
        int size = 0;
        while(current!=null){
            size++;
            current = current.next;
        }
        ListNode start = head;
        current = head;
        int big = size%k;
        int partSize = size/k;
        int index = 1;
        int arrIndex = 0;
        while(current!=null){
            if(big>0){
                if(index == partSize+1){
                    res[arrIndex++] = start;
                    start = current.next;
                    current.next = null;
                    current = start;
                    index = 1;
                    big--;
                    continue;
                }
            }
            else{
                if(index == partSize){
                    res[arrIndex++] = start;
                    start = current.next;
                    current.next = null;
                    current = start;
                    index = 1;
                    continue;
                }
            }
            current = current.next;
            index++;
        }
        return res;
    }
}