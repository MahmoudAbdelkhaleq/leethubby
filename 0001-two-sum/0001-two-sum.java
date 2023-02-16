import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            data.put(nums[i],i);
        }
        int [] ans = new int[2];
        for(int i =0;i<nums.length;i++){
            if(data.containsKey(target-nums[i]) && i!= data.get(target-nums[i])){
                ans[0]=i;ans[1]=data.get(target-nums[i]);
                break;
            }
        }
        return ans;
    }
}