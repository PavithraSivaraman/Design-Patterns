package creational;

//Singleton Logger
class Logger {
 private static Logger instance;

 private Logger() {
     // Private constructor
 }

 public static Logger getInstance() {
     if (instance == null) {
         instance = new Logger();
     }
     return instance;
 }

 public void log(String message) {
     System.out.println("Log: " + message);
 }
}

//Main class
public class SingletonPattern {
 public static void main(String[] args) {
     Logger logger1 = Logger.getInstance();
     Logger logger2 = Logger.getInstance();

     System.out.println(logger1 == logger2); // true
     logger1.log("This is a single instance logger.");
 }
}

