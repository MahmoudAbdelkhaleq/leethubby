class CustomStack {

    int last;
    int [] arr;
    public CustomStack(int maxSize) {
        arr = new int [maxSize];
    }
    
    public void push(int x) {
        if(last < arr.length)
            arr[last++] = x;
    }
    
    public int pop() {
        if(last>0)
            return arr[--last];
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i<k && i<last;i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */