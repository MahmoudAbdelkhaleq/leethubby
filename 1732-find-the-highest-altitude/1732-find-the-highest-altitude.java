class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int max = 0;
        for(int a: gain){
            alt+=a;
            if(alt>max)max = alt;
        }
        return max;
    }
}