package Armia;

import java.util.ArrayList;

public class Czolg {
    static private int numberGenerator = 0;
    public String tankNumber;
    private final ArrayList<Rozkaz> orderList = new ArrayList<Rozkaz>();

    public Czolg(){
        numberGenerator++;
        this.tankNumber = new String("" + numberGenerator);
    }

    public String ostatniRozkaz() {
        return "Ostatni rozkaz do mnie: " + orderList.get(orderList.size() - 1);
    }

    public String getOrderList() {
        StringBuilder orders = new StringBuilder();
        for(Rozkaz order : orderList){
            orders.append(order);
        }
        return orders.toString() + "\n";
    }

    public void addOrder(Rozkaz order) {
        this.orderList.add(order);
    }

    public String getTankNumber() {
        return tankNumber;
    }
}
