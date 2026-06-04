class Solution {
    public int findJudge(int n, int[][] trust) {
        
        Map<Integer,List<Integer>> trusts = new HashMap<>();
        Map<Integer,Set<Integer>> isTrusted = new HashMap<>();

        for(int[] tru:trust){
            trusts.computeIfAbsent(tru[0], k -> new ArrayList<>()).add(tru[1]);
            isTrusted.computeIfAbsent(tru[1], k -> new HashSet<>()).add(tru[0]);
        }

        int res = -1;
        for(int i =1; i< n+1; i++){
            if(!trusts.containsKey(i)){
                if(isTrusted.containsKey(i)){
                    if(isTrusted.get(i).size() == n-1){
                        if(res != -1)return -1;
                        res = i;
                    }
                }
            }
        }
        return res;
    }
}