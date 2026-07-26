class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        Map<Integer,Integer> counts = new HashMap<>();

        for(char c: s.toCharArray()){
            int i = c - 'a';
            counts.put(i,counts.getOrDefault(i,0)+1);
        }

        for(int i:counts.keySet()){
            pq.add(new int[] {i,counts.get(i)});
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(res.size() == 0 || res.get(res.size()-1) != first[0]){
                res.add(first[0]);
                first[1]--;
                if(first[1]>0){
                    pq.offer(first);
                }
            }
            else if(!pq.isEmpty()){
                int[] second = pq.poll();
                res.add(second[0]);
                second[1]--;
                if(second[1]>0){
                    pq.offer(second);
                }
                pq.offer(first);
            }
            else{
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i:res){
            sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }
}



