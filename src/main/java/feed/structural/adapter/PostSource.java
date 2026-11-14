package feed.structural.adapter;

import feed.creational.factory.Post;
import java.util.List;

// Target interface understood by the internal application.
public interface PostSource {
    List<Post> getPosts();
}
