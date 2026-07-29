class Solution {
    public void backtrack(Map<Character,String> map,List<String> res,String digits, int i ,StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int j = i; j < digits.length(); j++){
            String curString = map.get(digits.charAt(j));
            for(char c:curString.toCharArray()){
                sb.append(c);
                backtrack(map,res,digits,j+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }   
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
            '2' , "abc",
            '3' , "def",
            '4' , "ghi",
            '5' , "jkl",
            '6' , "mno",
           '7' , "pqrs",
            '8' , "tuv",
            '9' , "wxyz"
        );
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(digits.length() == 0)return res; 
        backtrack(map,res,digits,0,sb);
        return res;

    }
}