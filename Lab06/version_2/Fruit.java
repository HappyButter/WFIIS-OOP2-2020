public class Fruit extends Product {
    int daysToRot;

    Fruit(String name, int buyPrice, int sellPrice){
        super.isRottable = true;
        super.name = name;
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;

        this.daysToRot = 1;
    }

    @Override
    public void decreaseDaysToRot() {
        daysToRot--;
    }

    @Override
    public int getDaysToRot() {
        return daysToRot;
    }
}
