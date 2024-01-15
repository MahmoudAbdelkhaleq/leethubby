class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> records = new HashMap<>();
        for(int i = 0;i<matches.length;i++){
            records.computeIfAbsent(matches[i][0], k -> 0);
            records.put(matches[i][1], records.getOrDefault(matches[i][1], 0)+1);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> loseOneMatch = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : records.entrySet()) {
            if(entry.getValue() == 0) winners.add(entry.getKey());
            if(entry.getValue() == 1) loseOneMatch.add(entry.getKey());
        }
        Collections.sort(winners);
        Collections.sort(loseOneMatch);
        List<List<Integer>> res = new ArrayList<>();
        res.add(winners);
        res.add(loseOneMatch);
        return res;
    }
}