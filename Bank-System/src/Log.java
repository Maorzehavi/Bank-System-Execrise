import java.sql.Timestamp;

public class Log {
    private final Timestamp timestamp;
    private final int clientId;
    private final String description;
    private final float amount;

    public Log(int clientId, String description, float amount) {
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public String getData() {
        return "ClientId: " + clientId + " Message: " + description +
                " "+timestamp;
    }
}
