package feed.creational.factory;

import java.time.Instant;
import java.util.List;

public class ImagePostFactory extends PostFactory {
    @Override
    public Post createPost(String author, String content, List<String> hashtags,
                           boolean publicPost, Instant createdAt, int likes) {
        return new ImagePost(author, content, hashtags, publicPost, createdAt, likes);
    }
}
