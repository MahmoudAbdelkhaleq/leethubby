class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int [] res= new int[2];
        int count = 0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
               res[count++]=entry.getKey();
            }
            if(count == 2)break;
        } 
        return res;
    }
}