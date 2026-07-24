class Twitter {
    Map<Integer,Set<Integer>> followees;
    Map<Integer,List<int[]>> tweets;
    int time;
    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;

    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, j -> new ArrayList<>()).add(new int[] {tweetId,time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        followees.computeIfAbsent(userId, h ->new HashSet<>()).add(userId);
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        for(int curPerson:followees.getOrDefault(userId,new HashSet<>())){
            for(int[] cur:tweets.getOrDefault(curPerson, new ArrayList<>())){
                pq.add(cur);
                if(pq.size()>10){
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }
        Collections.reverse(res);
        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, h ->new HashSet<>()).add(followeeId);
        followees.get(followerId).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followees.getOrDefault(followerId,new HashSet<>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */