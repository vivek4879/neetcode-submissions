class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>,List<String>> map = new HashMap<>();
        for(String str:strs){
            List<Integer> curList = new ArrayList<>(Collections.nCopies(26, 0));
            for(int i = 0; i< str.length(); i++){
                int index = (int)str.charAt(i) - 'a';
                curList.set(index, curList.get(index) + 1);
            }
            if(!map.containsKey(curList)){
                map.put(curList,new ArrayList<String>());
            }
            List<String> newList = map.get(curList);
            newList.add(str);
            map.put(curList,newList);
        }
        return new ArrayList<>(map.values());

    }
}
