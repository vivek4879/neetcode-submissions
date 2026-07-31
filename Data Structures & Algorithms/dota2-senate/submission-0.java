class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        int n = senate.length();

        for(int i = 0; i < senate.length();i++){
            if(senate.charAt(i) == 'R'){
                radiant.add(i);
            }
            else{
                dire.add(i);
            }
        }

        while(true){
            if(radiant.size() == 0)return "Dire";
            if(dire.size() == 0)return "Radiant";
            if(dire.peek() < radiant.peek()){
                int cur = dire.removeFirst();
                dire.add(cur+n);
                radiant.removeFirst();
            }
            else{
                int cur = radiant.removeFirst();
                radiant.add(cur+n);
                dire.removeFirst();                
            }
        }
    }
}                 