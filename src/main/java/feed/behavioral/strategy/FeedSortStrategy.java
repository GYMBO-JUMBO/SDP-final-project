package feed.behavioral.strategy;

import feed.creational.factory.Post;
import java.util.List;

public interface FeedSortStrategy {
    // Return a sorted copy; never mutate the supplied list.
    List<Post> sort(List<Post> posts);
}
