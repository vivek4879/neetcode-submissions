class Solution {
    public String foreignDictionary(String[] words) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            for(int l = 0;l < word.length(); l++){
                set.add(word.charAt(l));
            }
        }
        int[] inIndex = new int[26];
        Map<Character,List<Character>> map = new HashMap<>();
        for(int i = 0; i < words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            if(second.length() < first.length() && first.startsWith(second))return "";
            for(int j = 0; j < Math.min(first.length(), second.length()); j++){
                if(first.charAt(j) == second.charAt(j))continue;
                map.computeIfAbsent(first.charAt(j), k -> new ArrayList<>()).add(second.charAt(j));
                inIndex[second.charAt(j) - 'a']++;
                break;
            }
        }

        Queue<Character> q = new LinkedList<>();

        for(int t = 0 ; t<inIndex.length; t++){
            if(inIndex[t] == 0 && set.contains((char)('a' + t)))q.add((char)('a' + t));
        }
        
        while(!q.isEmpty()){
            Character cur = q.remove();
            sb.append((char)cur);
            if(!map.containsKey(cur))continue;
            for(char nei:map.get(cur)){
                inIndex[nei - 'a']--;
                if(inIndex[nei - 'a'] == 0)q.add(nei);
            }
        }
    String res = sb.toString();
    if(res.length() < set.size())return "";
    return res;
    }
}
