class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] positions = new int[26];

        for(int i = 0; i < order.length(); i++){
            int idx = order.charAt(i) - 'a';
            positions[idx] = i;
        }

        for(int i = 1; i < words.length; i ++){
            String w1 = words[i-1];
            String w2 = words[i];
            if(w1.startsWith(w2) && w2.length() < w1.length())return false;
            for(int j = 0; j < Math.min(w1.length(),w2.length());j++){
                char first = w1.charAt(j);
                char second = w2.charAt(j);
                if(first != second){
                    if(positions[first - 'a'] > positions[second - 'a'])return false;
                    else{
                        break;
                    }
                }
            }
        }
        return true;
    }
}