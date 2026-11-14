package feed.structural.decorator;

import feed.creational.factory.Post;

public class BasicPostDisplay implements PostDisplay {
    private final Post post;

    public BasicPostDisplay(Post post) { this.post = post; }

    @Override
    public String display() {
        return "[" + post.getType() + "] " + post.getAuthor() + ": " + post.getContent()
                + " | " + String.join(" ", post.getHashtags())
                + " | " + (post.isPublic() ? "public" : "private")
                + " | " + post.getCreatedAt() + " | likes=" + post.getLikes();
    }
}
