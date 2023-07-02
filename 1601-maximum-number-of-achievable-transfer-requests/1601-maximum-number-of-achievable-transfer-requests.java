class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int [] buildings = new int [n];
        return helper(requests, buildings, 0, 0);
    }
    public static int helper(int [][] requests, int [] buildings, int index, int max){
        if(index == requests.length){
            if(balanced(buildings))
                return max;
            return -1;
        }
        if(requests[index][0] == requests[index][1])
            return helper(requests, buildings, index+1, max+1);
        int [] newBuildings = buildings.clone();
        newBuildings[requests[index][0]]--;
        newBuildings[requests[index][1]]++;
        return Math.max(helper(requests, buildings, index+1, max), helper(requests, newBuildings, index+1, max+1));
    }
    public static boolean balanced(int [] buildings){
        for(int i =0;i<buildings.length;i++){
            if(buildings[i]!=0)return false;
        }
        return true;
    }
}