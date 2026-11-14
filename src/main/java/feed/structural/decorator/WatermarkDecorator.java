package feed.structural.decorator;

public class WatermarkDecorator extends DisplayDecorator {
    public WatermarkDecorator(PostDisplay wrapped) { super(wrapped); }

    @Override
    public String display() { return wrapped.display() + " [Social Media Feed]"; }
}
