class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        if(s.length() == 1)return s;

        for(int i = 0; i < s.length()-1;i++){
            int l = i;
            int r = i;
            while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1> maxLen){
                    maxLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1> maxLen){
                    maxLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}