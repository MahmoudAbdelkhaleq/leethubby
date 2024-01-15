class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> lostOneMatch = new HashSet<>();
        Set<Integer> lostMatches = new HashSet<>();
        for(int i = 0;i<matches.length;i++){
            winners.add(matches[i][0]);
            winners.add(matches[i][1]);
        }
        for(int i = 0;i<matches.length;i++){
            if(winners.contains(matches[i][1]))
                winners.remove(matches[i][1]);
        }
        for(int i = 0;i<matches.length;i++){
            if(lostOneMatch.contains(matches[i][1]))
                lostMatches.add(matches[i][1]);
            else lostOneMatch.add(matches[i][1]);
        }
        lostOneMatch.removeAll(lostMatches);
        List<List<Integer>> res= new ArrayList<>();
        res.add(new ArrayList<>(winners));
        res.add(new ArrayList<>(lostOneMatch));
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}