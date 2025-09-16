package tech.zeta.practice.logging;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcerciseA {
    private static final Logger logger = Logger.getLogger(ExcerciseA.class.getName());

    // Log formatting
    static String formatLog(Level level, String className, String methodName, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("[%s] [%s] [%s] [%s] - %s",
                timestamp, level, className, methodName, message);
    }

    //we can use logging to record function calls
    static void  myFunction(){
        logger.info(formatLog(Level.INFO, "LoggingDemo", "myFunction", "called myFunction"));
        System.out.println("Executing myFunction");
    }

    public static void main(String[] args) {

        // 3. Error Handling and Logging
        try {
            int result = 10 / 0; // triggers ArithmeticException
            logger.info(formatLog(Level.INFO, "LoggingDemo", "main", "Division result: " + result));
        } catch (Exception e) {
            logger.log(Level.SEVERE, formatLog(Level.SEVERE, "LoggingDemo", "main", "An error occurred"), e);
        }
    }
}
