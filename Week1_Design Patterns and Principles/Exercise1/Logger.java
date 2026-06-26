public class Logger {
    
    // Private static instance
    private static Logger instance;

    // Private constructor
    private Logger() {
    }

    // Public method to get instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}