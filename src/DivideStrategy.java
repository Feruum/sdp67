public class DivideStrategy implements OperationStrategy {
    public double execute(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        return firstNumber / secondNumber;
    }
}
