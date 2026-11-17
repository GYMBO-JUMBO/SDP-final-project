package feed.creational.factory;

import java.time.Instant;
import java.util.List;

// Factory Method: subclasses decide which concrete Post to instantiate.
public abstract class PostFactory {
    public abstract Post createPost(String author, String content, List<String> hashtags,
                                    boolean publicPost, Instant createdAt, int likes);
}
