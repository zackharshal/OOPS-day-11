public class Account {
    private int totalBalance;
    public Account(int totalBalance){
        this.totalBalance = totalBalance;
    }
    public void withdrawMoney(int amount){
        if(amount < totalBalance){
            System.out.println("Amount debited through the account is " + amount);
            totalBalance -= amount;
        }else{
            System.out.println("The debit amount has exceed the account balance.");
        }
    }
    public static void main(String[] args) {
        Account account1 = new Account(12000);
        account1.withdrawMoney(15000);
    }
}
