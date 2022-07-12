public class Account {
    private final int id;
    private float balance;

    public Account(int id, float balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return id == account.id;
    }

    public boolean equals(int id) {
        return this.id == id;
    }
}
