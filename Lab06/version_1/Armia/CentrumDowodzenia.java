package Armia;

import java.util.ArrayList;

public class CentrumDowodzenia {
    private final ArrayList<Czolg> tankList = new ArrayList<Czolg>();

    public void zarejestrujCzolg(Czolg tankToRegister) {
        this.tankList.add(tankToRegister);
    }

    public void wydajRozkaz(String s, Rozkaz order) {
        for(Czolg tank : tankList){
            if (s.equals(tank.getTankNumber())){
                tank.addOrder(order);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder headquarterStatus = new StringBuilder("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
        for(Czolg tank : tankList){
            headquarterStatus.append(new String("Czolg nr " + tank.getTankNumber() + " otrzymal rozkazy:\n"));
            headquarterStatus.append(tank.getOrderList());
        }
        return headquarterStatus.toString();
    }
}
