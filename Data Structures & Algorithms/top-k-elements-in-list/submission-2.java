class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i:map.keySet()){
            int index = map.get(i);
            if(bucket[index] == null)bucket[index] = new ArrayList<>();
            bucket[index].add(i);
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i = bucket.length-1; i>=0 && idx < k; i--){
            if(bucket[i] == null)continue;
            for(int num: bucket[i]){
                res[idx++] = num;
                if(idx == k)break;
            }
        }
        return res;

    }
}
