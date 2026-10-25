import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, OperationStrategy> strategies = new HashMap<>();
        strategies.put("1", new AddStrategy());
        strategies.put("2", new SubtractStrategy());
        strategies.put("3", new MultiplyStrategy());

        Calculator calculator = new Calculator(strategies.get("1"));

        while (true) {
            System.out.println();
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("0. Exit");
            System.out.print("Choose an operation: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break;
            }

            OperationStrategy strategy = strategies.get(choice);

            if (strategy == null) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            double firstNumber = readNumber(scanner, "First number: ");
            double secondNumber = readNumber(scanner, "Second number: ");

            calculator.setStrategy(strategy);
            double result = calculator.calculate(firstNumber, secondNumber);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                double number = Double.parseDouble(scanner.nextLine());

                if (Double.isFinite(number)) {
                    return number;
                }

                System.out.println("Please enter a finite number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
