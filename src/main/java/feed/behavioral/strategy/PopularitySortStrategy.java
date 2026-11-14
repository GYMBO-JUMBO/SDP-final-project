package feed.behavioral.strategy;

import feed.creational.factory.Post;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PopularitySortStrategy implements FeedSortStrategy {
    @Override
    public List<Post> sort(List<Post> posts) {
        List<Post> sorted = new ArrayList<>(posts);
        sorted.sort(Comparator.comparingInt(Post::getLikes).reversed());
        return sorted;
    }
}
