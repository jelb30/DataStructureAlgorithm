package problems.design;
import java.util.*;

class Twitter {

    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private int timeCounter;                          // global clock, increments per post
    private Map<Integer, List<Tweet>> tweets;        // user -> their tweets (in post order)
    private Map<Integer, Set<Integer>> following;    // user -> set of people they follow

    public Twitter() {
        timeCounter = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new Tweet(tweetId, timeCounter++));   // stamp + advance clock
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap by timestamp: most recent tweet sits on top.
        PriorityQueue<Tweet> heap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // The feed = the user's own tweets + everyone they follow.
        Set<Integer> feedUsers = new HashSet<>();
        feedUsers.add(userId);
        Set<Integer> followees = following.get(userId);
        if (followees != null) {
            feedUsers.addAll(followees);
        }

        // Push every relevant tweet into the heap.
        for (int user : feedUsers) {
            List<Tweet> userTweets = tweets.get(user);
            if (userTweets != null) {
                for (Tweet tweet : userTweets) {
                    heap.offer(tweet);
                }
            }
        }

        // Pop the 10 most recent.
        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty() && feed.size() < 10) {
            feed.add(heap.poll().id);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}