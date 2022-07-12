public class Bank {
    private Client[] clients;

    private float bankBalance;
//    private Logger logger;

    // turn to singleton
    private static Bank instance = null;
    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public Bank() {
        clients = new Client[100];
//        logger = new Logger(null); // TODO: change null
    }

    public float getBankBalance() {
        return this.bankBalance;
    }
    public float getTotalFortune() {
        float totalFortune = 0;
        for (Client client : clients) {
            if (client != null) {
                totalFortune += client.getFortune();
            }
        }
        return totalFortune;
    }
    public void addClient(Client client) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                Logger.log(new Log(client.getId(), "Client added successfully", client.getBalance()));
                break;
            }
        }
    }
    public void removeClient(int id) {
        for (int i = 0; i < clients.length; i++) {
            Client client = clients[i];
            if (client != null && client.getId() == id) {
//                this.bankBalance += client.getFortune();
                Logger.log(new Log(id, " Client removed successfully", client.getBalance()));
                client = null;
                break;
            }
        }
    }
    public Client[] getClients() {
        return clients;
    }
    public void viewLogs() {
        Logger.getLogs();
    }
    public void startAccountUpdater(){

    }
    public Client getClients(int id) {
        for (Client client : clients) {
            if (client != null && client.getId() == id) {
                return client;
            }
        }
        return null;
    }
    public void printClientList() {
        for (Client client : clients) {
            if (client != null) {
                System.out.println(client);
            }
        }
    }
    public void addCommission(float amount) {
        this.bankBalance += amount;
    }
}
