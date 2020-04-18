
public class lab1 {

    public static void main(String[] args) {

        Runnable hwA1 = new PrintChar('A', 10);
        Runnable hwA2 = new PrintChar('B', 10);
        Runnable hwB = new PrintNum(45);
        Thread t1 = new Thread(hwA1);
        Thread t2 = new Thread(hwA2);
        Thread t3 = new Thread(hwB);
        t1.start();
        t2.start();
        t3.start();

        //Q3
        final BankAccount bankAccount = new BankAccount(5000);
        Thread bankAccountThread1 = new Thread("WithdrawThread_1") {
            public void run() {
                bankAccount.makeWithdrawal(6000);
            }
        };

        Thread bankAccountThread2 = new Thread("DepositThread_1") {
            public void run() {
                bankAccount.makeDeposit(2000);
            }
        };

        Thread bankAccountThread3 = new Thread("WithdrawThread_2") {
            public void run() {
                bankAccount.makeWithdrawal(500);
            }
        };

        Thread bankAccountThread4 = new Thread("WithdrawThread_3") {
            public void run() {
                bankAccount.makeWithdrawal(1500);
            }
        };

        Thread bankAccountThread5 = new Thread("DepositThread_2") {
            public void run() {
                bankAccount.makeDeposit(10000);
            }
        };

        bankAccountThread1.start();
        bankAccountThread2.start();
        bankAccountThread3.start();
        bankAccountThread4.start();
        bankAccountThread5.start();

    }
}

class PrintChar implements Runnable {

    private char ID;
    private int times;

    public PrintChar(char ID, int times) {
        this.ID = ID;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(ID);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintNum implements Runnable {

    private int givenNumber;

    public PrintNum(int givenNumber) {
        this.givenNumber = givenNumber;
    }

    public void run() {
        for (int i = 0; i < givenNumber; i++) {
            System.out.println(i+1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

