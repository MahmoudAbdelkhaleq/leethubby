class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<10;i++)
            recursion(res, i, n);
        return res;
    }
    void recursion(List<Integer> res, int number, int n){
        if(number<=n){
            res.add(number);
            for(int i = 0;i<10 && number <= n/10;i++){
                recursion(res, number*10+i,n);
            }
        }
    }
}