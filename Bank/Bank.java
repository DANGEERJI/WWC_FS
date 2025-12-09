class Bank{

    private String accountNumber;
    private String accountName;
    protected double balance;

    Bank(String accNo, String accName, double balance){
        accountNumber = accNo;
        accountName = accName;
        this.balance = balance;
    }

    void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        balance += amount;
    }

    void withdraw(double amount){
        if(balance - amount < 0){
            throw new RuntimeException("Insufficient Balance");
        }
        balance -= amount;
    }

    void printDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
    }

    class SavingAccount{

        void withdraw(double amount){
            if(amount <= 0){
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            else if(balance - amount < 0){
                throw new RuntimeException("Insufficient Balance");
            }
            else
                balance -= amount;
        }
    }


    public static void main(String[] args){
        Bank b = new Bank("9896", "Aalo", 98765);
        Bank.SavingAccount saving = b.new SavingAccount();
        b.deposit(5000);
        b.printDetails();
        b.withdraw(1000);
        b.printDetails();
        saving.withdraw(100);
        b.printDetails();
    }
}