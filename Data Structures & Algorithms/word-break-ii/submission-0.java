class TrieNode{
    Character val;
    Map<Character,TrieNode> children;
    boolean isWord;
    String word;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isWord = false;    

    }
    public TrieNode(Character val){
        this.val = val;
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

class Solution {

    public void backtrack(List<String> res, String s, TrieNode root, int i, StringBuilder sb){
        if(root == null)return;
        if(i == s.length()){
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        TrieNode cur = root;
        for(int j = i; j < s.length(); j++){
            if(!cur.children.containsKey(s.charAt(j)))break;
            cur = cur.children.get(s.charAt(j));
            if(cur.isWord){
                int len = sb.length();
                sb.append(cur.word);
                sb.append(" ");
                backtrack(res,s,root, j+1,sb);     
                sb.delete(len,sb.length());           
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        
        for(String word: wordDict){
            TrieNode cur = root;
            for(char c: word.toCharArray()){
                if(!cur.children.containsKey(c)){
                    cur.children.put(c,new TrieNode(c));
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
            cur.word = word;
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, s, root,0, sb);
        return res;

    }
}


