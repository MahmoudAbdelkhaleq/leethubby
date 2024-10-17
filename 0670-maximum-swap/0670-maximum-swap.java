class Solution {
    public int find(char c, int index, int [] digitsCount){
        for(int i = 9;i>c-'0';i--){
            if(digitsCount[i] >-1 && index< digitsCount[i])
                return digitsCount[i];
        }
        return -1;
    }
    public int maximumSwap(int num) {
        int [] digitsCount = new int [10];
        Arrays.fill(digitsCount, -1);
        String numString = num+"";
        for(int i = 0;i<numString.length();i++){
            digitsCount[numString.charAt(i)-'0'] = i;
        }
        for(int i = 0;i<=numString.length()-1;i++){
            int index = find(numString.charAt(i), i, digitsCount);
            if(index>-1){
                String s = numString.substring(0,i) + numString.charAt(index) +
                        numString.substring(i+1, index) +
                        numString.charAt(i) +
                        numString.substring(index+1);
                return Integer.parseInt(s);
            }
        }
        return num;
    }
}