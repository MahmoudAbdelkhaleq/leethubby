class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i= 0;
        int j = letters.length-1;
        while(i<=j){
            int index = (i+j)/2;
            if(index == 0){
                return letters[index];
            }
            else{
                if(target<letters[index] && target>=letters[index-1]){
                    return letters[index];
                }
                else{
                    if(target>=letters[index]){
                        i = index+1;
                    }
                    if(target<letters[index-1]){
                        j = index;
                    }
                }
            }
        }
        return letters[0];
    }
}