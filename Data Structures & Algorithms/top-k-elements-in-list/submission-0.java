class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num:map.keySet()){
            pq.add(new int[]{map.get(num), num});
            if(pq.size()>k){
                pq.remove();
            }
        }

        int[] res = new int[k];
        for(int i =0; i< k;i++){
            res[i] = pq.remove()[1];
        }
        return res;
    }
}
