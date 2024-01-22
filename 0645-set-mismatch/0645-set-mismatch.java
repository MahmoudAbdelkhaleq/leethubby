class Solution {
    public int[] findErrorNums(int[] arr) {
        int [] count = new int [arr.length+1];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int [] res = new int [2];
        for(int i =0;i<count.length;i++){
            if(count[i]==2)res[0] = i;
            if(count[i]==0)res[1] = i;
            if(res[0]!=0 && res[1]!=0)break;
        }
        return res;
    }
}