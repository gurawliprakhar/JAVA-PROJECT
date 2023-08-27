import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the first Number(or enter 'q' to quit)");
            String input = scan.next();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            long num1 = Long.parseLong(input);

            System.out.println("Enter an Operator(+,-,*,/): ");
            char operator = scan.next().charAt(0);

            System.out.println("Enter the second number: ");
            long num2 = scan.nextLong();

            long result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("cannot devided by zero.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid operstor.");
                    return;
            }
            System.out.println("result: " + result);
        }
        System.out.println("Calculator program finished");
        scan.close();

    }

}
