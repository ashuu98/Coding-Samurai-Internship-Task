package atm;



import java.util.HashMap;

public class ATMSystem {
    private HashMap<String, Account> accounts;

    public ATMSystem() {
        accounts = new HashMap<>();
        accounts.put("1001", new Account("1001", "1234", 5000));
        accounts.put("1002", new Account("1002", "2345", 10000));
        accounts.put("1003", new Account("1003", "3456", 7500));
    }

    public Account login(String accNo, String pin) {
        Account account = accounts.get(accNo);
        if (account != null && account.getPin().equals(pin)) {
            return account;
        }
        return null;
    }
}
