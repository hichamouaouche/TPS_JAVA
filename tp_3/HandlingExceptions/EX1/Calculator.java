public class Calculator {

    // Task 1: Method divide(a, b)
    public void divide(double a, double b) {
        try {
            if (b == 0) {
                // Manually throwing an exception to catch it below,
                // or you can simply print the error here directly.
                throw new ArithmeticException("Division by zero");
            }
            double result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero not possible.");
        }
    }

    // Task 2: Method convertToNumber(text)
    public void convertToNumber(String text) {
        try {
            // Tries to parse the string as a double (covers integers and decimals)
            double number = Double.parseDouble(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + text + "' is not a valid number");
        }
    }

    // Task 3: Method calculate(operation, a, b)
    public void calculate(String operation, double a, double b) {
        switch (operation) {
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                divide(a, b); // Reusing the divide method to handle zero check
                break;
            default:
                System.out.println("Error: Operation '" + operation + "' not supported");
                break;
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("--- Testing divide ---");
        calc.divide(10, 2);  // Valid
        calc.divide(10, 0);  // Error

        System.out.println("\n--- Testing convertToNumber ---");
        calc.convertToNumber("123");  // Valid
        calc.convertToNumber("abc");  // Error

        System.out.println("\n--- Testing calculate ---");
        calc.calculate("+", 5, 3);    // Valid
        calc.calculate("&", 5, 3);    // Error
    }
}