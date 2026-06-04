class Solution {
    public int findJudge(int n, int[][] trust) {
        
        Set<Integer> trusts = new HashSet<>();
        Map<Integer,Integer> isTrusted = new HashMap<>();

        for(int[] tru:trust){
            trusts.add(tru[0]);
            isTrusted.put(tru[1], isTrusted.getOrDefault(tru[1],0)+1);
        }

        for(int i =1; i< n+1; i++){
            if(!trusts.contains(i)){
                if(isTrusted.getOrDefault(i,0) == n-1){
                    return i;
                }
            }
        }
        return -1;
    }
}