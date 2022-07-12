import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = Bank.getInstance();
        RegularClient regularClient = new RegularClient(1, "John", 10000);
        GoldClient goldClient = new GoldClient(2, "Mary", 25000);
        PlatinumClient platinumClient = new PlatinumClient(3, "Peter", 50000);
        regularClient.addAccount(new Account(11, 1000));
        regularClient.addAccount(new Account(12, 1000));
        regularClient.addAccount(new Account(13, 1000));

        goldClient.addAccount(new Account(21, 2500));
        goldClient.addAccount(new Account(22, 2500));
        goldClient.addAccount(new Account(23, 2500));

        platinumClient.addAccount(new Account(31, 5000));
        platinumClient.addAccount(new Account(32, 5000));
        platinumClient.addAccount(new Account(33, 5000));

        bank.addClient(regularClient);
        bank.addClient(goldClient);
        bank.addClient(platinumClient);

        System.out.println(bank.getClients(1));
        System.out.println(bank.getClients(2));
        System.out.println(bank.getClients(3));

        regularClient.deposit(1000);
        goldClient.deposit(2000);
        platinumClient.deposit(3000);

        regularClient.deposit(100);
        goldClient.deposit(200);
        platinumClient.deposit(300);


        System.out.println(bank.getBankBalance()+"\n"+bank.getTotalFortune()+"\n");;
        System.out.println(bank.getClients(1).getFortune());
        System.out.println(bank.getClients(2).getFortune());
        System.out.println(bank.getClients(3).getFortune()+"\n");

        for (int i = 0; i < bank.getClients().length; i++) {
            if (bank.getClients()[i] != null) {
                System.out.println(bank.getClients()[i]);
            }
        }
            for (int j = 0; j < 3; j++) {
                bank.getClients(1).getAccounts()[j].setBalance(1500);
                bank.getClients(2).getAccounts()[j].setBalance(3000);
                bank.getClients(3).getAccounts()[j].setBalance(6000);
            }

        System.out.println();
        bank.getClients(1).autoUpdateAccounts();
        bank.getClients(2).autoUpdateAccounts();
        bank.getClients(3).autoUpdateAccounts();
        System.out.println();
        for (int i = 0; i < bank.getClients().length; i++) {
            if (bank.getClients()[i] != null) {
                System.out.println(bank.getClients()[i]);
            }

        }

    }

}