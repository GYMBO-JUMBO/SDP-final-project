package feed.structural.adapter;

import feed.creational.builder.PostBuilder;
import feed.creational.factory.Post;
import feed.creational.factory.TextPostFactory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// Adapter translates external fields into the same posts used by the feed.
public class ExternalPostAdapter implements PostSource {
    private final MockSocialApi api;

    public ExternalPostAdapter(MockSocialApi api) { this.api = api; }

    @Override
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        for (ExternalPost entry : api.fetchEntries()) {
            posts.add(new PostBuilder(new TextPostFactory())
                    .author(entry.getUsername()).content(entry.getMessage())
                    .createdAt(Instant.ofEpochSecond(entry.getEpochSeconds()))
                    .likes(entry.getHearts()).hashtag("external").build());
        }
        return posts;
    }
}
