class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber>0){
            int mod = (columnNumber-1) % 26;
            columnNumber = (columnNumber-1) / 26;
            res.insert(0,(char)('A'+mod));
        }
        return res.toString();
    }
}