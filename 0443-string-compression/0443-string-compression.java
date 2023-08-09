class Solution {
    public int compress(char[] chars) {
        int count =0;
        int currentCount = 1;
        char currentChar=chars[0];
        for(int i =1;i<chars.length;i++){
            if(chars[i]!=currentChar){
                chars[count]=currentChar;
                count++;
                if(currentCount>1){
                    for (char c : Integer.toString(currentCount).toCharArray()) {
                        chars[count++] = c;
                    }
                }
                currentChar=chars[i];
                currentCount=0;
            }
            currentCount++;
        }
        chars[count++]=currentChar;
        if(currentCount>1){
            for (char c : Integer.toString(currentCount).toCharArray()) {
                chars[count++] = c;
            }
        }
        return count;
    }
}