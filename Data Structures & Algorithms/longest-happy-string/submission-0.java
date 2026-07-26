class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((f,g) -> Integer.compare(g[1],f[1]));
        if(a!=0)pq.offer(new int[] {0, a});
        if(b!=0)pq.offer(new int[] {1, b});
        if(c!=0)pq.offer(new int[] {2, c});

        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length()<=1){
                sb.append((char) (first[0] +'a'));
                first[1]--;
                if(first[1] >0){
                    pq.offer(first);
                }
            }
            else if(sb.charAt(sb.length()-2) != (char)(first[0]+'a') || sb.charAt(sb.length()-1) != (char)(first[0] + 'a')){
                sb.append((char) (first[0] +'a'));
                first[1]--;
                if(first[1] >0){
                    pq.offer(first);
                }
            }
            else if(!pq.isEmpty()){
                int[] second = pq.poll();
                sb.append((char) (second[0] +'a'));
                second[1]--;
                if(second[1]>0){
                    pq.offer(second);
                }
                pq.offer(first);
            }
            else{
                break;
            }
        }

        return sb.toString();

    }
}