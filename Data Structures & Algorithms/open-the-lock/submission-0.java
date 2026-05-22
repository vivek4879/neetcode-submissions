class Solution {
    public List<String> getPossibles(String cur){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < cur.length(); i++){
            char[] curArray = cur.toCharArray();
            int one = curArray[i] - '0';
            curArray[i] = (char)('0' + (one+1) %10);
            res.add(new String(curArray));
            curArray[i] = (char)('0' + (one+10-1) %10);
            res.add(new String(curArray));
        }
        return res;
        
    }
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(String end:deadends){
            seen.add(end);
        }
        if(seen.contains("0000"))return -1;
        beginSet.add("0000");
        seen.add("0000");
        endSet.add(target);
        seen.add(target);
        int res = 0;
        while(!beginSet.isEmpty()){

            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            //we always expand the smaller set to balance the sets
            Set<String> nextSet = new HashSet<>();
            for(String curEntry:beginSet){
                List<String> neis = getPossibles(curEntry);
                for(String nei:neis){
                    if(endSet.contains(nei))return res+1;
                    if(seen.contains(nei))continue;
                    nextSet.add(nei);
                    seen.add(nei);
                }
            }
            beginSet = nextSet;           
            res++;
        }
        return -1;
    }
}