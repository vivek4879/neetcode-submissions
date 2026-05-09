class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> adj = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for(String word:words){
            for(char c: word.toCharArray()){
                adj.put(c, new ArrayList<>());
                counts.put(c,0);
            }
        }

        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length());j++){
                char word1C = word1.charAt(j);
                char word2C = word2.charAt(j);
                if(word1C != word2C){
                    adj.get(word1C).add(word2C);
                    counts.put(word2C, counts.get(word2C)+1);
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        for(char c:counts.keySet()){
            if(counts.get(c) == 0)q.add(c);
        }

        while(!q.isEmpty()){
            char cur = q.remove();
            res.append(cur);
            for(char curC:adj.get(cur)){
                counts.put(curC, counts.get(curC)-1);
                if(counts.get(curC) == 0){
                    q.add(curC);
                }
            }
        }
        if(res.length() < counts.size())return "";
        return res.toString();   
    
    }
}
