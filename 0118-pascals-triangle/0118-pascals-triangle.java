class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> row1 = new ArrayList();
        row1.add(1);
        res.add(row1);
        for(int i = 1;i<numRows;i++){
            List<Integer> row = new ArrayList();
            row.add(1);
            for(int j = 1;j<=i;j++){
                if(j==i)row.add(1);
                else row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }
}