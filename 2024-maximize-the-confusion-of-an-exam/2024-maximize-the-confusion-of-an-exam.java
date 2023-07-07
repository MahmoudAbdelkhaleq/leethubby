class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int Ts = 0;
        int Fs = 0;
        int index = 0;
        int maxLength=0;
        for(int i =0;i<answerKey.length();i++){
            if(answerKey.charAt(i)=='T')Ts++;
            else Fs++;
            if((Ts>=Fs && Fs <= k) || (Ts<=Fs && Ts <= k)){
                if(Ts+Fs>maxLength)maxLength = Ts+Fs;
            }
            if(Ts>k && Fs>k){
                if(answerKey.charAt(index++)=='T')Ts--;
                else Fs--;
            }
        }
        return maxLength;
    }
}