/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node res = new Node(head.val);
        Node current = head;
        Node resCurrent = res;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, res);
        while(current.next!=null){
            resCurrent.next = new Node(current.next.val);
            resCurrent = resCurrent.next;
            current = current.next;
            map.put(current, resCurrent);
        }
        current = head;
        resCurrent = res;
        while(current!=null){
            resCurrent.random = map.get(current.random);
            resCurrent = resCurrent.next;
            current = current.next;
        }
        return res;
    }
}