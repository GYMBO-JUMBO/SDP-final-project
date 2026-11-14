package feed.behavioral.observer;

import feed.creational.factory.Post;

public class UserFollower implements Observer {
    private final String name;

    public UserFollower(String name) { this.name = name; }

    @Override
    public void update(Post post) {
        System.out.println("Notification to " + name + ": " + post.getAuthor()
                + " published a new " + post.getType() + " post.");
    }
}
