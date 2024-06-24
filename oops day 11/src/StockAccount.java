import java.util.Scanner;
public class StockAccount {
    private final String stockName;
    private final int numberOfShares;
    private final int price;
    private static int totalPrice;
    public StockAccount(String stockName, int numberOfShares, int price) {
        this.numberOfShares = numberOfShares;
        this.stockName = stockName;
        this.price = price;
        totalPrice+= numberOfShares * price;
    }
    public void printInfo(){
        System.out.println("Stock name: "+stockName);
        System.out.println("Stock price: "+ price);
        System.out.println("Total value of stock: "+ (numberOfShares*price));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stock accounts: ");
        int num = scanner.nextInt();
        StockAccount[] stockAcc = new StockAccount[num];
        for(int i = 0;i < num; i++){
            System.out.println("Enter the necessary information for the account " +(i+1));
            System.out.println("Enter the  Stock name: ");
            String name = scanner.next();
            System.out.println("Enter the number of shares: ");
            int shares = scanner.nextInt();
            System.out.println("Enter the share price: ");
            int price = scanner.nextInt();
            stockAcc[i] = new StockAccount(name, shares, price);
        }
        for(int i = 0; i < num; i++){
            stockAcc[i].printInfo();
        }
        System.out.println("Total value of all the shares: "+ StockAccount.totalPrice);
    }
}