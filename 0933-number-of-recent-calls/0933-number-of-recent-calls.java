class RecentCounter {
    LinkedList<Integer> req;
    public RecentCounter() {
        req = new LinkedList<>();
    }
    
    public int ping(int t) {
        req.addLast(t);
        while(t-req.getFirst() > 3000){
            req.removeFirst();
        }
        return req.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */