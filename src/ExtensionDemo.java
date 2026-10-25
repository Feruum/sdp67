public class ExtensionDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new AddStrategy());
        System.out.println("12 + 4 = " + calculator.calculate(12, 4));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println("12 - 4 = " + calculator.calculate(12, 4));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println("12 * 4 = " + calculator.calculate(12, 4));

        calculator.setStrategy(new DivideStrategy());
        System.out.println("12 / 4 = " + calculator.calculate(12, 4));
    }
}
