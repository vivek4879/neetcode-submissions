class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;

        for(int i = 0 ; i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                left++;
            }
            else{
                left--;
            }
            if(left < 0)return false;
        }
        for(int i = s.length()-1 ; i >=0;i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*'){
                right++;
            }
            else{
                right--;
            }
            if(right < 0)return false;
        }
        return true;
    }
}