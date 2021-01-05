public class StosElement<T> {
    private T value;
    private StosElement<T> previousElement;

    StosElement(T value, StosElement<T> prev) {
        this.value = value;
        this.previousElement = prev;
    }

    @Override
    public String toString() {
        return "{" +
                value +
                '}';
    }

    public StosElement<T> getPreviousElement() {
        return previousElement;
    }
}
