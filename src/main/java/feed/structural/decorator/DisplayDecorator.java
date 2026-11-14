package feed.structural.decorator;

// The decorator is itself a component, so decorators can be stacked.
public abstract class DisplayDecorator implements PostDisplay {
    protected final PostDisplay wrapped;

    protected DisplayDecorator(PostDisplay wrapped) { this.wrapped = wrapped; }
}
