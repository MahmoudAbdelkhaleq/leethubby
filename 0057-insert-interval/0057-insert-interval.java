class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<int []>();
        for(int i =0;i<intervals.length;i++){
            res.add(intervals[i]);
        }
        for(int i=0;i<res.size();i++){
            if(newInterval[0]<intervals[i][0]){
                res.add(i,newInterval);
                break;
            }
        }
        if(intervals.length == res.size()) res.add(newInterval);
        for(int i = 0;i<res.size()-1;i++){
            if(overlap(res.get(i),res.get(i+1))){
                int [] merged = {res.get(i)[0],Math.max(res.get(i)[1], res.get(i+1)[1])};
                res.remove(i);
                res.remove(i);
                res.add(i--,merged);
            }
        }
        int [][] result = new int [res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
    public static boolean overlap(int [] i1, int [] i2){
        if(i1[1]<i2[0]) return false;
        return true;
    }
}