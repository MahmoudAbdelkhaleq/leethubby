import java.util.*;
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length== 1) return new ArrayList<List<Integer>>();
        List<List<Integer>> perms= new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        Hashtable<List<Integer>,Integer> hash = new Hashtable<List<Integer>,Integer>();
        hash.put(sub,-200);
        helper(hash,sub,nums,0);
        Enumeration<List<Integer>> e = hash.keys();
        while (e.hasMoreElements()){
            List<Integer> key = e.nextElement();
            if(key.size()>=2)
                perms.add(key);
        }
        return perms;
    }
    public static void helper (Hashtable<List<Integer>,Integer> hash,List<Integer> subsequence, int[] nums, int i){
        if(i<nums.length){
            helper(hash,new ArrayList<Integer>(subsequence),nums,i+1);
            if(nums[i]>=hash.get(subsequence)){
                List<Integer> subsequence2 = new ArrayList<Integer>(subsequence);
                subsequence2.add(nums[i]);
                hash.put(subsequence2,nums[i]);
                helper(hash,new ArrayList<Integer>(subsequence2),nums,i+1);
            }
        }
        else return;
    }
}