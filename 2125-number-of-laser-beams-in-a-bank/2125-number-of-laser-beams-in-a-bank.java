class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int start = 0;
        int end = 1;
        if(bank.length == 1) return 0;
        boolean found = countOnes(bank[start]) == 0;
        while(end<bank.length){
            if(!found && countOnes(bank[start]) == 0){
                found = true;
                start++;
                end = start+1;
                continue;
            }
            if(countOnes(bank[end]) == 0){
                end++;
                continue;
            }
            res+=countOnes(bank[start])*countOnes(bank[end]);
            start = end++;
            found = false;
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