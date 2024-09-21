class Solution {
    public List<Integer> lexicalOrder(int n) {
        int digits = 0;
        int k = n;
        while(k>0){
            digits++;
            k = k/10;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<10;i++)
            recursion(res, ""+i, digits, n);
        return res;
    }
    void recursion(List<Integer> res, String num, int digits, int n){
        int number = Integer.parseInt(num);
        if(num.length()<digits){
            res.add(number);
            for(int i = 0;i<10;i++)
                recursion(res, num+i,digits,n);
        }
        else if(Integer.parseInt(num) <= n){
            res.add(number);
        }
    }
}