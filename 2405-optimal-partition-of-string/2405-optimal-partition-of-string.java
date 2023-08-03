class Solution {
    public int partitionString(String s) {
        // String current = "";
        // int count = 0;
        // for(int i = 0;i<s.length();i++){
        //     if(current.contains(s.charAt(i)+"")){
        //         current = "";
        //         count++;
        //     }
        //     current+=s.charAt(i)+"";
        // }
        // if(!current.equals(""))count++;
        // return count;
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }
}