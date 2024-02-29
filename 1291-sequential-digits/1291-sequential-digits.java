class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int minLen = (low+"").length();
        int maxLen = (high+"").length();
        List<Integer> res = new ArrayList<>();
        for(int i = minLen;i<=maxLen;i++){
            List<Integer> l = generateList(i);
            for(int j = 0;j<l.size();j++){
                if(l.get(j)>=low && l.get(j)<=high)res.add(l.get(j));
            }
        }
        return res;
    }
    public List<Integer> generateList(int length){
        List<Integer> l = new ArrayList<>();
        for(int i = 1;i<=10-length;i++){
            String s= "";
            int num = i;
            for(int j = 0;j<length;j++){
                s+=num++;
            }
            l.add(Integer.parseInt(s));
        }
        return l;
    }
}