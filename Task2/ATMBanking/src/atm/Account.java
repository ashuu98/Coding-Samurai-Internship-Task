package atm;



public class Account {
    private String accNo;
    private String pin;
    private double balance;

    public Account(String accNo, String pin, double balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccNo() { return accNo; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
