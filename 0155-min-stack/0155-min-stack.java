class MinStack {
    ArrayList<Integer> list;
    PriorityQueue<Integer> pq;
    public MinStack() {
        list = new ArrayList<Integer>();
        pq = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
        list.add(val);
        pq.offer(val);
    }
    
    public void pop() {
        Integer val = list.get(list.size()-1);
        list.remove(list.size()-1);
        pq.remove(val);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */