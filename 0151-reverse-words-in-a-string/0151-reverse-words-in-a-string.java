class Solution {
    public String reverseWords(String s) {
        boolean space = true;
        String res = "";
        String word = "";
        List<String> words = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(space){
                    continue;
                }
                words.add(word);
                word="";
                space = true;
            }
            else{
                word=word+""+s.charAt(i);
                space = false;
            }
        }
        if(!word.equals("")) words.add(word);
        for(int i =words.size()-1;i>=0;i--){
            res += words.get(i)+" ";
        }
        if(res.charAt(0)==' ') return res.substring(1);
        return res.substring(0,res.length()-1);
    }
}