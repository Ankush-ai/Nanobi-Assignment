import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitSummation {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Accepting user inputs
        System.out.print("Enter the number of digits: ");
        int numberOfDigits = scanner.nextInt();

        System.out.print("Enter the list count: ");
        int listCount = scanner.nextInt();

        System.out.print("Enter the desired outcome of the summation of the digits: ");
        int desiredOutcome = scanner.nextInt();

        // Validate inputs
        if (numberOfDigits < 1 || numberOfDigits > 9 || desiredOutcome < 1 || desiredOutcome > 9) {
            System.out.println(
                    "Invalid input! Please enter values between 1 and 9 for number of digits and desired outcome.");
            return;
        }

        // Generating list of numbers based on the number of digits
        List<Integer> resultList = generateNumbers(numberOfDigits, listCount, desiredOutcome);

        // Display the result
        System.out.println("List of count of probable digits:");
        for (int number : resultList) {
            System.out.println(number);
        }
    }

    private static List<Integer> generateNumbers(int numberOfDigits, int listCount, int desiredOutcome) {
        List<Integer> validNumbers = new ArrayList<>();
        int start = (int) Math.pow(10, numberOfDigits - 1);
        int end = (int) Math.pow(10, numberOfDigits);

        for (int i = start; i < end; i++) {
            if (getSingleDigitSum(i) == desiredOutcome) {
                validNumbers.add(i);
            }
            if (validNumbers.size() == listCount) {
                break;
            }
        }
        return validNumbers;
    }

    private static int getSingleDigitSum(int number) {
        while (number >= 10) {
            number = sumOfDigits(number);
        }
        return number;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
