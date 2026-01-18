public class Vehicle {

    // 2. The Vehicle class offers an empty constructor
    public Vehicle() {
        // No attributes to initialize
    }

    // Method testSpeed() takes an integer and throws exception if > 90
    // Since TooFastException inherits from Exception, we must declare 'throws'
    public void testSpeed(int speed) throws TooFastException {
        if (speed > 90) {
            throw new TooFastException(speed);
        } else {
            System.out.println("Speed " + speed + " is acceptable.");
        }
    }

    // 3. Add a main to the Vehicle class
    public static void main(String[] args) {
        Vehicle myCar = new Vehicle();

        // --- First Call: Safe Speed (e.g., 85) ---
        try {
            System.out.println("Testing speed 85...");
            myCar.testSpeed(85);
        } catch (TooFastException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");

        // --- Second Call: Unsafe Speed (e.g., 120) ---
        try {
            System.out.println("Testing speed 120...");
            myCar.testSpeed(120);
        } catch (TooFastException e) {
            // Display the call stack of the exception
            e.printStackTrace();
        }
    }
}