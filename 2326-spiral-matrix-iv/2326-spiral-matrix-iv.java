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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] res = new int [m][n];
        for(int [] arr : res){
            Arrays.fill(arr, -1);
        }
        int occJ = 0;
        int occI = 1;
        while(head!=null){
            for(int j = occJ; j<res[0].length-occJ && head!=null;j++){
                res[occJ][j] = head.val;
                head = head.next;
            }
            for(int i = occI; i<res.length-occI+1 && head!=null;i++){
                res[i][res[0].length-occI] = head.val;
                head = head.next;
            }
            occJ++;
            occI++;
            for(int j = res[0].length-1-occJ; j>=occJ-1 && head!=null;j--){
                res[res.length-occJ][j] = head.val;
                head = head.next;
            }
            for(int i = res.length-occI; i>=occI-1 && head!=null;i--){
                res[i][occI-2] = head.val;
                head = head.next;
            }
        }
        return res;
    }
}