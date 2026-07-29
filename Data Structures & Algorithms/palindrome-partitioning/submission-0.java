class Solution {

    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }

    public void backtrack(List<List<String>> res, String s, int i,List<String> path){
        if(i == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < s.length(); j++){
            String subString = s.substring(i,j+1);
            if(isPalindrome(subString)){
                path.add(subString);
                backtrack(res,s,j+1,path);
                path.remove(path.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,s,0,new ArrayList<>());
        return res;
    }
}