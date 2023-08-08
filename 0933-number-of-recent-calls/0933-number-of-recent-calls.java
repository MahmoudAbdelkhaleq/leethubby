class RecentCounter {

    int counter;
    List<Integer> req;
    public RecentCounter() {
        req = new ArrayList<>();
        counter= 0;
    }
    
    public int ping(int t) {
        req.add(t);
        counter++;
        int reqs = 1;
        for(int i =req.size()-2;i>=0;i--){
            if(t-req.get(i)<=3000) reqs++;
        }
        return reqs;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */