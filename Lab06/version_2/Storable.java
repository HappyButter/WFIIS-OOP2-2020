public interface Storable {
    void setName(String name);
    void setBuyPrice(int price);
    void setSellPrice(int price);

    boolean isRottable();
    String getName();
    int getBuyPrice();
    int getSellPrice();
}
