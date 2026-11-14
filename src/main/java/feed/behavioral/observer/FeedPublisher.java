package feed.behavioral.observer;

import feed.behavioral.strategy.Feed;
import feed.creational.factory.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Subject publishes into the shared feed and synchronously notifies subscribers.
public class FeedPublisher implements Subject {
    private final Feed feed;
    private final List<Observer> followers = new ArrayList<>();

    public FeedPublisher(Feed feed) { this.feed = feed; }

    @Override
    public void subscribe(Observer observer) {
        Objects.requireNonNull(observer);
        if (!followers.contains(observer)) { followers.add(observer); }
    }
    @Override
    public void unsubscribe(Observer observer) { followers.remove(observer); }
    @Override
    public void notifyFollowers(Post post) {
        for (Observer follower : new ArrayList<>(followers)) { follower.update(post); }
    }
    public void publish(Post post) {
        feed.addPost(post);
        System.out.println("Published: " + post.getAuthor() + " - " + post.getContent());
        notifyFollowers(post);
    }
}
