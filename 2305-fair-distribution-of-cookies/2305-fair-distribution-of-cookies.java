class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int [] boys = new int [k];
        return helper(cookies, boys, 0, Integer.MAX_VALUE);
    }
    public static int helper(int [] cookies, int [] boys, int index, int min){
        if(index == cookies.length)
            return max(boys);
        for(int i =0;i<boys.length;i++){
            if(boys.length-i>cookies.length-index)continue;
            int[] newBoys = boys.clone();
            newBoys[i] = newBoys[i]+cookies[index];
            int res = helper(cookies, newBoys, index+1, min);
            if(res<min)min = res;
        }
        return min;
    }
    public static int max(int [] a){
        int max = Integer.MIN_VALUE;
        for(int i =0;i<a.length;i++){
            if(a[i]>max)max = a[i];
        }
        return max;
    }
}