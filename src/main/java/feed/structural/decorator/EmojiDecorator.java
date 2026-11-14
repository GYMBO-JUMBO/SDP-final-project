package feed.structural.decorator;

public class EmojiDecorator extends DisplayDecorator {
    public EmojiDecorator(PostDisplay wrapped) { super(wrapped); }

    @Override
    public String display() { return "✨ " + wrapped.display() + " ✨"; }
}
