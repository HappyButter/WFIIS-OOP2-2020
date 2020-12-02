public class Product implements Storable, Rottable{
    String name;
    int buyPrice;
    int sellPrice;
    boolean isRottable;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBuyPrice(int price) {
        this.buyPrice = price;
    }

    @Override
    public void setSellPrice(int price) {
        this.sellPrice = price;
    }

    @Override
    public boolean isRottable() {
        return isRottable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }

    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public void decreaseDaysToRot() {

    }

    @Override
    public int getDaysToRot() {
        return 0;
    }
}
