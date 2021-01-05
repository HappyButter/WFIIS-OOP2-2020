public class Stos<T> {
    StosElement<T> lastElement;

    Stos(){
        this.lastElement = null;
    }

    public void push(T val) {
        StosElement<T> newElement = new StosElement<>(val, this.lastElement);
        this.lastElement = newElement;
    }

    public void pop() {
        if(this.lastElement != null) {
            this.lastElement = this.lastElement.getPreviousElement();
        }
    }

    @Override
    public String toString() {
        StosElement<T> currentElement = this.lastElement;
        StringBuilder sb = new StringBuilder();

        while(currentElement != null){
            sb.append(currentElement.toString());
            sb.append(" ");
            currentElement = currentElement.getPreviousElement();
        }
        return sb.toString();
    }
}
