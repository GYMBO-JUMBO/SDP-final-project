package feed.behavioral.strategy;

import feed.creational.factory.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Context delegates sorting to the currently selected strategy.
public class Feed {
    private final List<Post> posts = new ArrayList<>();
    private FeedSortStrategy strategy;

    public Feed(FeedSortStrategy strategy) { setSortStrategy(strategy); }
    public void setSortStrategy(FeedSortStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }
    public void addPost(Post post) { posts.add(Objects.requireNonNull(post)); }
    public List<Post> getPosts() { return List.copyOf(posts); }
    public List<Post> getSortedPosts() { return strategy.sort(getPosts()); }
}
