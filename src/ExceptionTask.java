public class ExceptionTask {
    public static void main(String[] args) {
        try {
            int numerator = 10;
            int denominator = 0;
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero");
        } finally {
            System.out.println("Execution finished");
        }
        String input = "1la3";
        try {
            int number = Integer.parseInt(input);
            System.out.println("Successfully converted to integer: " + number);
        } catch (NumberFormatException e) {
            System.err.println("Error occured");
        } finally {
            System.out.println("Execution finished");
        }
    }
}
