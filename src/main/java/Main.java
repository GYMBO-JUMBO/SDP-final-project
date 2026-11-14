import feed.creational.builder.PostBuilder;
import feed.creational.factory.*;
import feed.structural.adapter.*;
import feed.structural.decorator.*;
import feed.behavioral.observer.*;
import feed.behavioral.strategy.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOCIAL MEDIA FEED ===");
        System.out.println("\n=== FACTORY METHOD & BUILDER ===");
        PostFactory textFactory = new TextPostFactory();
        PostFactory imageFactory = new ImagePostFactory();
        Post text = new PostBuilder(textFactory).author("Alice")
                .content("Learning design patterns!").hashtag("java").hashtag("patterns")
                .publicPost(true).createdAt(Instant.parse("2025-01-01T10:00:00Z")).likes(50).build();
        Post image = new PostBuilder(imageFactory).author("Bob")
                .content("sunset.jpg").hashtag("photography").publicPost(false)
                .createdAt(Instant.parse("2025-01-01T14:00:00Z")).likes(10).build();
        System.out.println(new BasicPostDisplay(text).display());
        System.out.println(new BasicPostDisplay(image).display());

        Feed feed = new Feed(new ChronologicalSortStrategy());
        FeedPublisher publisher = new FeedPublisher(feed);
        UserFollower charlie = new UserFollower("Charlie");
        UserFollower dana = new UserFollower("Dana");
        publisher.subscribe(charlie);
        publisher.subscribe(dana);
        System.out.println("\n=== OBSERVER: NEW POST ===");
        publisher.publish(text);
        publisher.publish(image);

        System.out.println("\n=== ADAPTER: EXTERNAL CONTENT ===");
        PostSource source = new ExternalPostAdapter(new MockSocialApi());
        for (Post external : source.getPosts()) { publisher.publish(external); }

        System.out.println("\n=== DECORATOR: POST DISPLAY ===");
        PostDisplay decorated = new WatermarkDecorator(new EmojiDecorator(new BasicPostDisplay(text)));
        System.out.println(decorated.display());
        System.out.println("Original content: " + text.getContent());

        System.out.println("\n=== STRATEGY: CHRONOLOGICAL FEED ===");
        displayFeed(feed);
        System.out.println("\n=== STRATEGY: POPULARITY FEED ===");
        feed.setSortStrategy(new PopularitySortStrategy());
        displayFeed(feed);
        System.out.println("Stored insertion order: "
                + feed.getPosts().stream().map(Post::getAuthor).toList());

        System.out.println("\n=== OBSERVER: UNSUBSCRIBE ===");
        publisher.unsubscribe(dana);
        System.out.println("Dana unsubscribed. Only Charlie receives the next notification.");
        publisher.publish(new PostBuilder(textFactory).author("Alice")
                .content("The project demo is complete.")
                .createdAt(Instant.parse("2025-01-01T16:00:00Z")).build());
    }

    private static void displayFeed(Feed feed) {
        for (Post post : feed.getSortedPosts()) {
            System.out.println(new BasicPostDisplay(post).display());
        }
    }
}
