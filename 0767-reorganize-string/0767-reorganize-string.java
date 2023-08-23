import java.util.Comparator;
import java.util.PriorityQueue;

class CharCount{
    int count;
    char c;
    public CharCount(char c, int count){
        this.count = count;
        this.c=c;
    }
    public int compare(CharCount charCount){
        if(count>=charCount.count) return -1;
        return 1;
    }
    public void reduce(){
        count--;
    }
}
class CharComparator implements Comparator<CharCount> {
    public int compare(CharCount c1, CharCount c2) {
        return c1.compare(c2);
    }
}
class Solution {
    public String reorganizeString(String s) {
        int [] counts = new int[26];
        for(char c: s.toCharArray()){
            counts[c-'a']++;
        }
        PriorityQueue<CharCount> pq = new PriorityQueue<>(new CharComparator());
        for(int i =0;i<counts.length;i++){
            if(counts[i]>0){
                int c ='a'+i;
                pq.offer(new CharCount((char)c, counts[i]));
            }
        }
        int count = 0;
        char lastChar = ';';
        StringBuilder res = new StringBuilder();
        while (count<s.length()){
            if(pq.peek().count>0) {
                if (pq.peek().c != lastChar) {
                    CharCount cC = pq.poll();
                    res.append(cC.c + "");
                    cC.reduce();
                    lastChar = cC.c;
                    pq.offer(cC);
                }
                else{
                    CharCount cC1 = pq.poll();
                    if(pq.isEmpty() || pq.peek().count==0) return "";
                    CharCount cC2 = pq.poll();
                    res.append(cC2.c + "");
                    cC2.reduce();
                    lastChar = cC2.c;
                    pq.offer(cC2);
                    pq.offer(cC1);
                }
            }
            else break;
        }
        return res.toString();
    }
}