class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //find max and min
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0;i<arrays.size();i++){
            if(arrays.get(i).get(0)<min){
                min = arrays.get(i).get(0);
                minIndex = i;
            }
            if(arrays.get(i).get(arrays.get(i).size()-1)>max){
                max = arrays.get(i).get(arrays.get(i).size()-1);
                maxIndex = i;
            }
        }
        if(minIndex == maxIndex){
            int secondMin = Integer.MAX_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for(int i = 0;i<arrays.size();i++){
                if(i!=minIndex){
                    if(arrays.get(i).get(0)<secondMin) {
                        secondMin = arrays.get(i).get(0);
                    }
                }
                if(i!=maxIndex) {
                    if (arrays.get(i).get(arrays.get(i).size() - 1) > secondMax) {
                        secondMax = arrays.get(i).get(arrays.get(i).size() - 1);
                    }
                }
            }
            return Math.max(max-secondMin, secondMax-min);
        }
        return max-min;
    }
}