class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<bank.length;i++){
            int count = countOnes(bank[i]);
            if(count != 0) list.add(count);
        }
        for(int i = 0;i<list.size()-1;i++){
            res+=list.get(i)*list.get(i+1);
        }
        return res;
    }
    private int countOnes(String row){
        int count = 0;
        for(int i = 0;i<row.length();i++)
            if(row.charAt(i)=='1')count++;
        return count;
    }
}