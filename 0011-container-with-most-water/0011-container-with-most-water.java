class Solution {
    public int maxArea(int[] height) {
        int j = height.length-1, i=0;
        int max = j*Math.min(height[i],height[j]);
        while(i<j){
            int cap = (j-i)*Math.min(height[i],height[j]);
            if(cap>max)max=cap;
            if(height[i]>=height[j]) 
                j--;
            else i++;
        }
        return max;
    }
}