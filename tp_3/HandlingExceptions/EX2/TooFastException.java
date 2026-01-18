// 1. Write the TooFastException class inheriting from the Exception class.
public class TooFastException extends Exception {
    
    // The constructor takes an integer as a parameter
    public TooFastException(int speed) {
        // Calls the super-constructor with the specific message
        super("This is an exception of type TooFastException. Speed involved: " + speed);
    }
}