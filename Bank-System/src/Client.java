//import java.util.Arrays;
//import java.util.Objects;

import java.util.Arrays;

public abstract class Client {
    private final int id;
    private String name;
    private float balance;
    private final Account[] accounts;
    protected float commissionRate;
    protected float interestRate;
//    private final Logger logger;

    public Client(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        accounts = new Account[5];
//        logger = new Logger(null); // TODO: change null
    }

    public void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                Logger.log(new Log(this.id, "Account add successfully", account.getBalance()));
                break;
            }
        }
    }

    public Account getAccount(int id) {
        for (Account account : accounts) {
            if (account != null && account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public void removeAccount(int id) {
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            if (account.getId() == id) {
                this.setBalance(this.balance + account.getBalance());
                Logger.log(new Log(id, " Account removed successfully", account.getBalance()));
                account = null;
                break;
            }
        }
    }

    public void printAccounts() {
//        Arrays.stream(accounts).filter(Objects::nonNull).forEach(System.out::println);
        for (Account account : accounts) {
            if (account != null) {
                System.out.println(account);
            }
        }
    }

    public void deposit(float amount) {
        if (commissionRate == 0) {
            this.balance += amount;
            Logger.log(new Log(this.id, "Deposit successfully", amount));
        } else {
            this.balance += amount * this.commissionRate;
            Bank.getInstance().addCommission(commissionRate * amount);
            Logger.log(new Log(this.id, "Deposit successfully", amount));
        }
    }

    public void withdraw(float amount) {
        if (amount > this.balance) {
            Logger.log(new Log(this.id, "Withdraw failed", amount));
        } else if (commissionRate == 0) {
            this.balance -= amount;
            Logger.log(new Log(this.id, "Withdraw successfully", amount));
        } else {
            this.balance -= amount * commissionRate;
            Bank.getInstance().addCommission(this.commissionRate * amount);
            Logger.log(new Log(this.id, "Withdraw successfully", amount));
        }
    }

    public void autoUpdateAccounts() {
        for (Account account : accounts) {
            if (account != null) {
                if (interestRate != 0) {
                    account.setBalance(account.getBalance() + account.getBalance() * interestRate);
                    Logger.log(new Log(this.id, "Interest added successfully", account.getBalance()));
                }
            }
        }
    }

    public float getFortune() {
        int x = 0;
        for (Account account : accounts) {
            if (account != null) {
                x += account.getBalance();
            }
        }
        return this.balance + x;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(float balance) {
        Logger.log(new Log(this.id, "Balance change", balance - this.balance));
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accounts=" + Arrays.toString(accounts) +
                ", commissionRate=" + commissionRate +
                ", interestRate=" + interestRate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id == client.id;
    }
    public boolean equals(int id) {
        return this.id == id;
    }
}
