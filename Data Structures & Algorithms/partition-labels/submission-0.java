class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = s.length()-1; i>=0; i--){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
        }
        int farthest = 0;
        int last = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< s.length(); i++){
            farthest = Math.max(farthest,map.get(s.charAt(i)));
            if(i == farthest){
                res.add(i - last + 1);
                last = i+1;
            }
        }
        return res;
    }
}