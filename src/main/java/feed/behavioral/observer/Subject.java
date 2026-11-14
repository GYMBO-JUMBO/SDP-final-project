package feed.behavioral.observer;

import feed.creational.factory.Post;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyFollowers(Post post);
}
