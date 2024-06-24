import java.util.Scanner;

public class StocksAcc {
    public static Scanner sc= new Scanner(System.in);
    private String name;
    private int numberOfShares;
    private float sharePrice;
    static float totalValue=0;
    private void valueOf(){
        System.out.printf("Stock value of %s : %.2f\n",name,sharePrice*numberOfShares);
    }
    public static void buy(StocksAcc[] stockArray){
        System.out.println("Enter the stock you want to buy");
        for(int i=0;i<stockArray.length;i++) {
            System.out.println("Stock name : " + stockArray[i].name);
        }
        String stock= sc.next();
        System.out.println("Enter the amount of stock");
        int number=sc.nextInt();
        for(int i=0;i<stockArray.length;i++) {
            if (stockArray[i].name.equals(stock)) {
                if (stockArray[i].numberOfShares >= number) {
                    stockArray[i].numberOfShares += number;
                }
            }
        }
    }
    private static void sell(StocksAcc[] stockArray){
        System.out.println("Enter the stock you want to sell");
        for(int i=0;i<stockArray.length;i++) {
            System.out.println("Stock name : " + stockArray[i].name);
        }
        String stock= sc.next();
        System.out.println("Enter the amount of stock");
        int number=sc.nextInt();
        for(int i=0;i<stockArray.length;i++){
            if (stockArray[i].name.equals(stock)){
                if (stockArray[i].numberOfShares>=number){
                    stockArray[i].numberOfShares-=number;
                }
                else {
                    System.out.println("Insufficient stocks");
                }
            }
        }

    }
    private void calcPrice(){
        System.out.println("Stock name : "+name);
        System.out.println("Number of shares: "+numberOfShares);
        System.out.println("Share price: "+sharePrice);

        totalValue+=sharePrice*numberOfShares;
    }
    private static void printReport (StocksAcc[] stockArray){
        System.out.println("-------------------------Stock Report-------------------------");
        for(int i=0;i<stockArray.length;i++){
            stockArray[i].calcPrice();
            System.out.println("-----------------------------------------------------------");
        }
        System.out.printf("Total value of all stocks: %.2f\n",totalValue);
    }
    public static void main(String[] args) {

        System.out.println("Enter the number of stocks");
        int n= sc.nextInt();
        StocksAcc[] stockArray=new StocksAcc[n];
        System.out.println("Enter stock details");
        for(int i=0;i<n;i++){
            StocksAcc s1=new StocksAcc();
            System.out.printf("Enter Stock name:\n");
            s1.name=sc.next();
            System.out.println("Enter the number of shares: ");
            s1.numberOfShares=sc.nextInt();
            System.out.println("Enter share price");
            s1.sharePrice=sc.nextFloat();
            stockArray[i]=s1;
        }
        buy(stockArray);
        sell(stockArray);
        printReport(stockArray);
    }
}