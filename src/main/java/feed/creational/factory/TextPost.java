package feed.creational.factory;

import java.time.Instant;
import java.util.List;

public class TextPost extends Post {
    public TextPost(String author, String content, List<String> hashtags,
                    boolean publicPost, Instant createdAt, int likes) {
        super(author, content, hashtags, publicPost, createdAt, likes);
    }
    @Override
    public String getType() { return "text"; }
}
