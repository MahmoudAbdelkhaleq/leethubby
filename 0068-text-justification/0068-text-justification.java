class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        int counter = words[0].length();
        for(int i =1;i<=words.length;i++){
            if(i == words.length){
                int spaces = maxWidth-counter;
                StringBuilder line = new StringBuilder();
                for(int j=start;j<i;j++){
                    line.append(words[j]);
                    if(spaces>0){
                        line.append(" ");
                        spaces--;
                    }
                }
                res.add(appendSpaces(line, spaces).toString());
                break;
            }
            counter = counter+words[i].length();
            end++;
            if(counter+(end-start)>maxWidth){
                counter = counter - words[i--].length();
                int spaces = maxWidth-counter;
                StringBuilder line = new StringBuilder();
                line.append(words[start]);
                if(end-start==1) res.add(appendSpaces(line, spaces).toString());
                else{
                    start++;
                    int slots = spaces/(end-start);
                    int mod = spaces%(end-start);
                    for(int j =start;j<end;j++){
                        if(mod-->0) line = appendSpaces(line, slots+1);
                        else line = appendSpaces(line, slots);
                        line.append(words[j]);
                    }
                    res.add(line.toString());
                }
                start = end;
                end = start-1;
                counter = 0;
            }
        }
        return res;
    }
    private StringBuilder appendSpaces(StringBuilder s, int spaces){
        for(int i =0;i<spaces;i++){
            s.append(" ");
        }
        return s;
    }
}