package feed.structural.adapter;

import java.util.List;

// Local data only; no network requests.
public class MockSocialApi {
    public List<ExternalPost> fetchEntries() {
        return List.of(new ExternalPost("TravelBot", "A postcard from the mountains!", 1735732800L, 25));
    }
}
