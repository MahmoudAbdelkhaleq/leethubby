class pqComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y)
    {
        if(x>=y)return -1;
        return 1;
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new pqComparator());
        for(int x:stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int newStone = pq.poll()-pq.poll();
            if(newStone>0) pq.offer(newStone);
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}