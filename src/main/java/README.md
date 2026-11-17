# Social Media Feed

A small Java 17 console application for a university Design Patterns final project. It demonstrates exactly six design patterns in one automatic workflow, with no runtime dependencies or network requests.

## Patterns

| Pattern | Main classes | Purpose |
| --- | --- | --- |
| Factory Method | `PostFactory`, `TextPostFactory`, `ImagePostFactory`, `Post`, `TextPost`, `ImagePost` | Concrete factories override `createPost()` to choose the post subtype through inheritance and polymorphism. |
| Builder | `PostBuilder` | Chained methods collect author, content, hashtags, privacy, timestamp and likes; `build()` delegates to the supplied factory. |
| Adapter | `PostSource`, `ExternalPostAdapter`, `MockSocialApi`, `ExternalPost` | Converts mock username/message/epoch-seconds/hearts fields into shared internal posts. |
| Decorator | `PostDisplay`, `BasicPostDisplay`, `DisplayDecorator`, `EmojiDecorator`, `WatermarkDecorator` | Wraps display components to add stackable effects without changing post data. |
| Observer | `Observer`, `Subject`, `UserFollower`, `FeedPublisher` | Publishing stores a post in the feed and synchronously notifies current followers. |
| Strategy | `FeedSortStrategy`, `ChronologicalSortStrategy`, `PopularitySortStrategy`, `Feed` | Switches between newest-first and most-liked-first sorting using copies of the stored collection. |

## Structure

```text
pom.xml
README.md
.gitignore
docs/
  class-diagram.puml
  workflow.md
src/main/java/
  Main.java
  feed/
    creational/
      factory/   Post, TextPost, ImagePost, PostFactory,
                 TextPostFactory, ImagePostFactory
      builder/   PostBuilder
    structural/
      adapter/   ExternalPost, MockSocialApi, PostSource, ExternalPostAdapter
      decorator/ PostDisplay, BasicPostDisplay, DisplayDecorator,
                 EmojiDecorator, WatermarkDecorator
    behavioral/
      observer/  Observer, Subject, UserFollower, FeedPublisher
      strategy/  FeedSortStrategy, ChronologicalSortStrategy,
                 PopularitySortStrategy, Feed
```

There are exactly six named Java packages. `Main` is the only class outside them. The shared domain model lives in the factory package; all other patterns reuse it.

## Compile and run

Install JDK 17 or newer and Maven 3.6.3 or newer. From the project root:

```sh
mvn clean package
java -jar target/social-media-feed-1.0.0.jar
```

Alternatively, after compilation:

```sh
java -cp target/classes Main
```

Maven compiles with `--release 17`. Its build plugins may need an initial download; the application itself runs offline. No input is required.

## Integrated demonstration

1. Builders configure a text post from Alice and an image post from Bob. Each builder invokes its selected concrete factory.
2. Charlie and Dana subscribe to the publisher. Publishing adds both posts to the same feed and notifies both followers.
3. The adapter converts a mock external entry from TravelBot into a text post using the same builder/factory path. Publishing it uses the same feed and notifications.
4. Emoji and watermark decorators wrap Alice's display. The original post content remains unchanged.
5. The feed first sorts by descending timestamp: **Bob, TravelBot, Alice**.
6. Changing its strategy sorts by descending likes: **Alice (50), TravelBot (25), Bob (10)**. Stored insertion order remains **Alice, Bob, TravelBot**. Equal keys retain insertion order.
7. Dana unsubscribes. A final Alice post notifies only Charlie.

See [the workflow notes](docs/workflow.md) and [the PlantUML diagram](docs/class-diagram.puml) for defense preparation.

## Educational scope

Image content is a filename displayed as text; no image files are loaded. Privacy is metadata displayed in the console, not access control: all subscribers receive notifications, including for the private sample. Posts are immutable snapshots, likes are sample values, and all data is stored in memory for one run. Author and content are required; hashtags default to empty, privacy to public, timestamp to the current instant and likes to zero. The demo supplies fixed timestamps for reproducible output. There is no authentication, persistence or real external service.
