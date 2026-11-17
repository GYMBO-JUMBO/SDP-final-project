package feed.creational.builder;

import feed.creational.factory.Post;
import feed.creational.factory.PostFactory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Builder assembles properties, then delegates creation to a Factory Method.
public class PostBuilder {
    private final PostFactory factory;
    private String author;
    private String content;
    private final List<String> hashtags = new ArrayList<>();
    private boolean publicPost = true;
    private Instant createdAt = Instant.now();
    private int likes;

    public PostBuilder(PostFactory factory) {
        this.factory = Objects.requireNonNull(factory);
    }

    public PostBuilder author(String author) { this.author = author; return this; }
    public PostBuilder content(String content) { this.content = content; return this; }
    public PostBuilder hashtag(String hashtag) {
        if (hashtag == null || hashtag.isBlank()) {
            throw new IllegalArgumentException("Hashtag must not be blank.");
        }
        hashtags.add(hashtag.startsWith("#") ? hashtag : "#" + hashtag);
        return this;
    }
    public PostBuilder publicPost(boolean publicPost) { this.publicPost = publicPost; return this; }
    public PostBuilder createdAt(Instant createdAt) { this.createdAt = createdAt; return this; }
    public PostBuilder likes(int likes) { this.likes = likes; return this; }

    public Post build() {
        return factory.createPost(author, content, hashtags, publicPost, createdAt, likes);
    }
}
