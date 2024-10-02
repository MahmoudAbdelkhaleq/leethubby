class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numsRank = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();
        for (int num : arr){
            nums.add(num);
        }
        int rank = 1;
        for (int num : nums) {
            numsRank.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numsRank.get(arr[i]);
        }
        return arr;
    }
}