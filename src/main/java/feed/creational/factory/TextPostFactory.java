package feed.creational.factory;

import java.time.Instant;
import java.util.List;

public class TextPostFactory extends PostFactory {
    @Override
    public Post createPost(String author, String content, List<String> hashtags,
                           boolean publicPost, Instant createdAt, int likes) {
        return new TextPost(author, content, hashtags, publicPost, createdAt, likes);
    }
}
