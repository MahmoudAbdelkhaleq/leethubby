class Solution {
    static String [] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static String myString = "";
    public List<String> letterCombinations(String digits) {
        List <String> result = new ArrayList<String>();
        if(digits.equals("")){
            return result;
        }
        letterCombinationsHelper(digits, result);
        return result;
    }
    public void letterCombinationsHelper(String digits, List<String> result){
        if(digits.equals("")){
            result.add(myString);
            // myString = myString.substring(0,myString.length()-1);
            return;
        }
        int num = Integer.parseInt(digits.charAt(0)+"");
        String numLetters = letters[num-2];
        for(int i =0;i<numLetters.length();i++){
            myString+=(numLetters.charAt(i)+"");
            letterCombinationsHelper(digits.substring(1,digits.length()), result);
            myString = myString.substring(0,myString.length()-1);
        }
    }
}