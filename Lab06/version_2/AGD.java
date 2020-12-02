public class AGD extends Product {

    AGD(String name, int buyPrice, int sellPrice){
        super.isRottable = false;
        super.name = name;
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;
    }
}
