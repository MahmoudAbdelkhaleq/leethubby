class KthLargest {
    int [] arr;
    int index = 0;
    int kth;
    public KthLargest(int k, int[] nums) {
        arr = new int [20000];
        Arrays.fill(arr,-1);
        kth = k;
        for(int n:nums){
            insert(n);
        }
    }
    
    public int add(int val) {
        insert(val);
        if(index-kth<0){
            return 0;
        }
        return arr[index-kth];
    }
    public void insert(int n){
        if(index == 0){
            arr[index] = n;
        }
        else{
            int i = index-1;
            for(;i>=0 && n<arr[i];i--){
                arr[i+1] = arr[i];
            }
            arr[i+1] = n;
        }
        index++;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */