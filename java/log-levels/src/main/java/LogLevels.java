public class LogLevels {
    
    public static String message(String logLine) {
        // split on ":"
        String[] parts = logLine.split(":");
        
        // if there is more than one part, return the second part
        if (parts.length > 1) {
            return parts[1].trim();
        } else {
            return "";
        }
    }

    public static String logLevel(String logLine) {
        // extract the log level from the log line
        String[] parts = logLine.split(":");
        if (parts.length > 1) {
            // replace "[" and "]" with ""
            String level = parts[0].replace("[", "").replace("]", "");
            return level.toLowerCase().trim();
        } else {
            return "";
        }
    }

    public static String reformat(String logLine) {
        return LogLevels.message(logLine) + " (" + LogLevels.logLevel(logLine) + ")";
    }
}
