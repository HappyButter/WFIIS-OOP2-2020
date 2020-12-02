import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> productsList = new ArrayList<>();
    static int balance = 0;

    enum ProductType{
        FRUIT,
        VEGETABLE,
        AGD
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String result;
            do {
                System.out.println("1) Dodaj towar\n" +
                        "2) Sprzedaj towar\n" +
                        "3) Kolejny dzień\n" +
                        "4) Bilans\n" +
                        "X) Koniec programu\n");
                result = input.nextLine();
            } while (!menuHandler(result));
        }
        catch(Exception e) {
            System.out.println("Exception: invalid input type.");
        }
    }

    private static boolean menuHandler(String result) {
        boolean isCrashed = false;
        switch (result){
            case "x":
            case "X":
                isCrashed = true;
                break;
            case "1":
                addProduct();
                break;
            case "2":
                sellProduct();
                break;
            case "3":
                newDay();
                break;
            case "4":
                printBalance();
                break;
            default:
                System.out.println("default");
        }
        return isCrashed;
    }

    private static void addProduct() {
        System.out.println("1) dodaj owoc\n" +
                "2) dodaj warzywo\n" +
                "3) dodaj drobne agd\n");

        Scanner inputProductType = new Scanner(System.in);
        String productType = inputProductType.nextLine();

        switch (productType){
            case "1":
                addProduct(ProductType.FRUIT);
                break;
            case "2":
                addProduct(ProductType.VEGETABLE);
                break;
            case "3":
                addProduct(ProductType.AGD);
                break;
            default:
                System.out.println("Wrong product choice!");
        }
    }

    private static void addProduct(ProductType type){
        Scanner inputProduct = new Scanner(System.in);

        String productName = getName(inputProduct);
        int productBuyPrice = getBuyPrice(inputProduct);
        int productSellPrice = getSellPrice(inputProduct);

        switch (type){
            case FRUIT:
                Fruit fruit = new Fruit(productName, productBuyPrice, productSellPrice);
                productsList.add(fruit);
                break;
            case VEGETABLE:
                Vegetable vegetable = new Vegetable(productName, productBuyPrice, productSellPrice);
                productsList.add(vegetable);
                break;
            case AGD:
                AGD agd = new AGD(productName, productBuyPrice, productSellPrice);
                productsList.add(agd);
            default:
                System.out.println("Error: product not added.\n");
        }
    }

    private static int getSellPrice(Scanner inputProduct) {
        System.out.println("podaj cene sprzedazy:");
        String productStringSellPrice = inputProduct.nextLine();
        return Integer.parseInt(productStringSellPrice);
    }

    private static int getBuyPrice(Scanner inputProduct) {
        System.out.println("podaj cene zakupu:");
        String productStringBuyPrice = inputProduct.nextLine();
        return Integer.parseInt(productStringBuyPrice);
    }

    private static String getName(Scanner inputProduct){
        System.out.println("Podaj nazwe:");
        return inputProduct.nextLine();
    }

    private static void newDay() {
        ArrayList<Integer> indexArray = new ArrayList<>();
        int i = 0;
        for (Product product : productsList){
            if(product.isRottable()){
                product.decreaseDaysToRot();
                if(product.getDaysToRot()==0){
                    indexArray.add(0, i);
                }
            }
            i++;
        }

        for(int index : indexArray){
            int value = productsList.get(index).getBuyPrice();
            productsList.remove(index);
            updateBalance(-value);
        }
    }

    private static void updateBalance(int balanceUpdateValue){
        balance = balance + balanceUpdateValue;
    }

    private static void printBalance() {
        System.out.println("Bilans: " + balance);
    }

    private static void sellProduct() {
        printList();

        System.out.println("\nKtory produkt chcesz usunac?");
        Scanner inputProductToSell = new Scanner(System.in);
        int index = inputProductToSell.nextInt();
        index = index - 1;

        int value = productsList.get(index).getSellPrice() - productsList.get(index).getBuyPrice();
        productsList.remove(index);
        updateBalance(value);
    }

    private static void printList() {
        System.out.println("Products list in the storage:");
        int i = 1;
        for(Product product : productsList){
            System.out.println(i++ + ". " + product.getName());
        }
    }
}
