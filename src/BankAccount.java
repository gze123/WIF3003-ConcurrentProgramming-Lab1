public class BankAccount extends Thread {
    private double balance;
    private int flag = 0;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
        System.out.println("Withdraw complete. Balance: " + this.balance);
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit complete. Balance: " + this.balance);
    }

    public synchronized double makeDeposit(double depositAmount) {
        System.out.println(Thread.currentThread().getName() + " is going to deposit");
        deposit(depositAmount);
        notifyAll();
        this.flag = 1;
        return this.balance;
    }

    public synchronized double makeWithdrawal(double withdrawAmount) {
        System.out.println(Thread.currentThread().getName() + " is going to withdraw");
        if (this.balance >= withdrawAmount) {
            this.withdraw(withdrawAmount);
        } else {
            try {
                System.out.println("Waiting…");
                System.out.println("Current Balance: " + this.balance);
                System.out.println("Withdraw Amount: " + withdrawAmount);
                wait();
                makeWithdrawal(withdrawAmount);
            } catch (Exception e) {
            }
        }
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", flag=" + flag +
                '}';
    }
}
