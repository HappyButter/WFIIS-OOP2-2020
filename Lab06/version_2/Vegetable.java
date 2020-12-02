public class Vegetable extends Product {
    int daysToRot;

    Vegetable(String name, int buyPrice, int sellPrice){
        super.isRottable = true;
        super.name = name;
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;

        this.daysToRot = 2;
    }
}
