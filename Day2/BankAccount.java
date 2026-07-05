package Day2;

public class BankAccount {
    private String m_ownerName;
    private int m_accountNumber;
    private double m_balance;

    public BankAccount(String p_ownerName, int p_accountNumber, double p_balance) {
        m_ownerName = p_ownerName;
        m_accountNumber = p_accountNumber;
        m_balance = p_balance;
    }

    public String getOwnerName() {
        return m_ownerName;
    }

    public int getAccountNumber() {
        return m_accountNumber;
    }

    public double getBalance() {
        return m_balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            m_balance += depositAmount;
            System.out.println("New Balance: " + m_balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > m_balance || withdrawAmount < 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            m_balance -= withdrawAmount;
            System.out.println("New Balance: " + m_balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Joe", 123456, 300.0);

        System.out.println("Owner: " + acc.getOwnerName()); // Expected: Joe
        System.out.println("Account #: " + acc.getAccountNumber()); // Expected: 123456
        System.out.println("Starting Balance: $" + acc.getBalance()); // Expected: 300.0

        // Valid deposit
        acc.deposit(100.0); // Expected: New balance: $400.0

        // Invalid deposit
        acc.deposit(0.0); // Expected: Invalid deposit amount.

        // Invalid deposit
        acc.deposit(-20.0); // Expected: Invalid deposit amount.

        // Valid withdrawal
        acc.withdraw(150.0); // Expected: New balance: $250.0

        // Invalid withdrawal (too large)
        acc.withdraw(1000.0); // Expected: Invalid withdrawal amount.

        // Invalid withdrawal (negative)
        acc.withdraw(-50.0); // Expected: Invalid withdrawal amount.

        // Final balance check
        System.out.println("Final Balance: $" + acc.getBalance()); // Expected: $250.0
    }

}
