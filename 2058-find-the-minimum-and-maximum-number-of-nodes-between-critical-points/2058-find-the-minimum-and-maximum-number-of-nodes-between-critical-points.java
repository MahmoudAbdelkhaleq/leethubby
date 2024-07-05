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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] res = new int[2];
        Arrays.fill(res, -1);
        ListNode current = head.next;
        int previous = head.val;
        int firstPoint = -1;
        int lastPoint = -1;
        int counter = 1;
        while(current.next!=null){
            if((current.val>previous && current.val>current.next.val)
            || (current.val<previous && current.val<current.next.val)){
                if(firstPoint == -1){
                    firstPoint = counter;
                    lastPoint = counter;
                }
                else{
                    if(counter-lastPoint<res[0] || res[0] == -1){
                        res[0] = counter-lastPoint;
                    }
                    lastPoint = counter;
                }
            }
            previous = current.val;
            current = current.next;
            counter++;
        }
        if(lastPoint != -1 && firstPoint !=-1 && firstPoint!=lastPoint)
            res[1] = lastPoint-firstPoint;
        return res;
    }
}