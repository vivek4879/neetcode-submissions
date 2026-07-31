class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length %groupSize != 0 )return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int h:hand){
            map.put(h,map.getOrDefault(h,0)+1);
        }
        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            int cur = hand[i];
            if(!map.containsKey(cur))continue;
            map.put(cur,map.get(cur)-1);
            if(map.get(cur) ==0){
                map.remove(cur);
            }
            int next = cur+1;
            int curLen = 1;
            while(curLen<groupSize && map.containsKey(next)){
                map.put(next,map.get(next)-1);
                if(map.get(next) ==0){
                    map.remove(next);
                }
                curLen++;
                next++;
            }
            if(curLen !=groupSize)return false;
        }
        return true;

    }
}