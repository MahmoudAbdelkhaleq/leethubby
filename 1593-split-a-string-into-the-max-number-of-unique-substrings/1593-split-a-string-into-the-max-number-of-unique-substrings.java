class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return count(s, set, 0);
        // HashMap<Integer, Integer> endStart = new HashMap<>();
        // int start = 0;
        // int count = 0;
        // for(int end = 0;end<s.length();end++){
        //     String sub = s.substring(start, end+1);
        //     if(!set.contains(sub)){
        //         count++;
        //         set.add(sub);
        //         endStart.put(end, start);
        //         start = end+1;
        //     }
        //     else{
        //         if(end == s.length()-1){
        //             for(;start<end;start++){
        //                 if(!set.contains(s.substring(start,end+1))){
        //                     count++;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        // return count;
    }
    private int count(String s, Set<String> set, int index){
        int max = 0;
        if(index == s.length()){
            return set.size();
        }
        for(int i = index;i<s.length();i++){
            String sub = s.substring(index, i+1);
            if(!set.contains(sub)){
                set.add(sub);
                max = Math.max(max, count(s, set, i+1));
                set.remove(sub);
            }
        }
        return max;
    }
}