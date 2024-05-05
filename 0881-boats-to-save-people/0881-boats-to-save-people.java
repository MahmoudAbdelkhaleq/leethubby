class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        int count = 0;
        while(start<=end){
            if(people[end]+people[start]<=limit){
                start++;
            }
            end--;
            count++;
        }
        return count;
    }
}