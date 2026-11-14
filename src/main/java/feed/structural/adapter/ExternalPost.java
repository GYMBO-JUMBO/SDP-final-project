package feed.structural.adapter;

// Simulated third-party format: different names and epoch seconds instead of Instant.
public class ExternalPost {
    private final String username;
    private final String message;
    private final long epochSeconds;
    private final int hearts;

    public ExternalPost(String username, String message, long epochSeconds, int hearts) {
        this.username = username;
        this.message = message;
        this.epochSeconds = epochSeconds;
        this.hearts = hearts;
    }
    public String getUsername() { return username; }
    public String getMessage() { return message; }
    public long getEpochSeconds() { return epochSeconds; }
    public int getHearts() { return hearts; }
}
