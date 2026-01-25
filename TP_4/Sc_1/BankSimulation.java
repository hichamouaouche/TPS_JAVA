class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // --- OPTION 1: UNSAFE METHOD (Causes Race Condition) ---
    /*
    public void withdraw(int amount, String clientName) {
        if (balance >= amount) {
            System.out.println(clientName + " is preparing to withdraw " + amount);
            
            // Simulate processing time to force the race condition
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            balance = balance - amount;
            System.out.println(clientName + " completed withdrawal. Remaining Balance: " + balance);
        } else {
            System.out.println(clientName + " tried to withdraw " + amount + " but insufficient funds. Balance: " + balance);
        }
    }
    */

    // --- OPTION 2: SYNCHRONIZED METHOD (The Fix) ---
    // The 'synchronized' keyword ensures only one thread can execute this method at a time.
    public synchronized void withdraw(int amount, String clientName) {
        System.out.println(clientName + " is attempting to withdraw " + amount);
        
        if (balance >= amount) {
            System.out.println(clientName + " sees sufficient funds. Proceeding...");
            
            // Even with a delay here, the lock prevents the other thread from entering
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            balance = balance - amount;
            System.out.println(clientName + " completed withdrawal. Remaining Balance: " + balance);
        } else {
            System.out.println(clientName + " denied. Insufficient funds. Balance: " + balance);
        }
    }
    
    public int getBalance() {
        return balance;
    }
}

class Client extends Thread {
    private BankAccount account;
    private int amount;
    private String clientName;

    public Client(BankAccount account, int amount, String clientName) {
        this.account = account;
        this.amount = amount;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        account.withdraw(amount, clientName);
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        // 1. Initialize the shared bank account
        BankAccount sharedAccount = new BankAccount(500);

        // 2. Create two clients (threads) sharing the same account instance
        Client client1 = new Client(sharedAccount, 450, "Client 1");
        Client client2 = new Client(sharedAccount, 100, "Client 2");

        // 3. Start the threads
        client1.start();
        client2.start();
    }
}