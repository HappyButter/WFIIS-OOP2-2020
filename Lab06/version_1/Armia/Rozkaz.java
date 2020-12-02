package Armia;

public class Rozkaz {
    private final String orderDescription;

    public Rozkaz(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription(){
        return this.orderDescription;
    }

    @Override
    public String toString() {
        return orderDescription + "\n";
    }
}
