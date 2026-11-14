package feed.behavioral.observer;

import feed.creational.factory.Post;

public interface Observer {
    void update(Post post);
}
