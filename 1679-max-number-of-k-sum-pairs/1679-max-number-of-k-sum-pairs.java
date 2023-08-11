class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int ops =0;
        int i =0;
        int j =list.size()-1;
        while(i<j){
            int x = list.get(i);
            int y = list.get(j);
            if(x+y==k){
                list.remove(j);
                list.remove(i);
                ops++;
                j = j-2;
            }
            if(x+y>k){
                j--;
            }
            if(x+y<k){
                i++;
            }
        }
        return ops;
    }
}