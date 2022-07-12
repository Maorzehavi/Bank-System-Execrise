public class Logger {
    private final String driverName;


    public Logger(String driverName) {
        this.driverName = driverName;
    }

    public static void log(Log log){
        System.out.println(log.getData());
    }

    public static Log[] getLogs(){
        return null;
    }

    public String getDriverName() {
        return driverName;
    }
}
