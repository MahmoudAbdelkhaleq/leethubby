class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            nums.add(i);
        }
        int index = 0;
        for(int i = 0;i<n-1;i++){
            index = (index + k - 1)%nums.size();
            nums.remove(index);
        }
        return nums.get(0);
    }
}