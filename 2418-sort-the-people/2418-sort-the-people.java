class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i = 1;i<heights.length;i++){
            int j = i-1;
            int height = heights[i];
            String name = names[i];
            for(;j>=0 && heights[j]<height;j--){
                heights[j+1] = heights[j];
                names[j+1] = names[j];
            }
            heights[j+1] = height;
            names[j+1] = name;
        }
        return names;
    }
}