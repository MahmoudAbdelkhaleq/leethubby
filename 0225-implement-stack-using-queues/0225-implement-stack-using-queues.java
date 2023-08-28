class MyStack {
    Queue<Integer> queue;
    Queue<Integer> temp;

    public MyStack() {
        queue = new LinkedList<Integer>();
        temp = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        while(queue.size()>1){
            temp.offer(queue.poll());
        }
        int x = queue.poll();
        while(!temp.isEmpty()){
            queue.offer(temp.poll());
        }
        return x;
    }
    
    public int top() {
        int x = 0;
        for(int i = 0;i<queue.size();i++){
            if(i==queue.size()-1) x = queue.peek();
            queue.offer(queue.poll());
        }
        return x;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */