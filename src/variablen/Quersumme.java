package variablen;

import java.util.Scanner;

public class Quersumme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        String[] numberArr = new String[5];

        while (!valid) {
            System.out.println("Geben Sie einer maximal 5-stelligen Zahl ein: ");
            String input = sc.nextLine();

            String[] inputArr = input.split("");
            if (inputArr.length > 5) {
                System.out.println("Die eingegebene Zahl ist ungültig. Geben Sie erneut eine Zahl ein!");
            } else {
                numberArr = inputArr;
                valid = true;
            }
        }

        int sum = sumNumbers(numberArr);

        for (int i = 0; i < numberArr.length; i++) {
            if (i == numberArr.length - 1)
                System.out.print(numberArr[i] + " = " + sum);
            else
                System.out.print(numberArr[i] + " + ");
        }
    }

    private static int sumNumbers(String[] numberArr) {
        int sum = 0;
        for (int i = 0; i < numberArr.length; i++)
            sum += Integer.parseInt(numberArr[i]);
        return sum;
    }
}
