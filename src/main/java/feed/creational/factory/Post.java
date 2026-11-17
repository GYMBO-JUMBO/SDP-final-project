package feed.creational.factory;

import java.time.Instant;
import java.util.List;

// Shared immutable post abstraction used by all six patterns.
public abstract class Post {
    private final String author;
    private final String content;
    private final List<String> hashtags;
    private final boolean publicPost;
    private final Instant createdAt;
    private final int likes;

    protected Post(String author, String content, List<String> hashtags,
                   boolean publicPost, Instant createdAt, int likes) {
        if (author == null || author.isBlank() || content == null || content.isBlank()) {
            throw new IllegalArgumentException("Author and content must not be blank.");
        }
        if (hashtags == null || createdAt == null || likes < 0) {
            throw new IllegalArgumentException("Hashtags and timestamp are required; likes must be nonnegative.");
        }
        this.author = author;
        this.content = content;
        this.hashtags = List.copyOf(hashtags);
        this.publicPost = publicPost;
        this.createdAt = createdAt;
        this.likes = likes;
    }

    public abstract String getType();
    public String getAuthor() { return author; }
    public String getContent() { return content; }
    public List<String> getHashtags() { return hashtags; }
    public boolean isPublic() { return publicPost; }
    public Instant getCreatedAt() { return createdAt; }
    public int getLikes() { return likes; }
}
