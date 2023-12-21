package string;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Geben Sie eine Rechnung ein (z.B 2+5): ");
        String input = sc.next();

        String[] charArr = input.split("");

        int firstDigit = 0;
        int secondDigit = 0;
        char operationSign;
        int result = 0;

        for (int i=0; i<charArr.length; i++) {
            char character = charArr[i].charAt(0);
            if (!Character.isDigit(character)) {
                firstDigit = Integer.parseInt(input.substring(0, i));
                secondDigit = Integer.parseInt(input.substring(i+1));
                operationSign = character;

                result = calculate(firstDigit, secondDigit, operationSign);
            }
        }

        System.out.println(result);
        sc.close();
    }

    private static int calculate(int firstDigit, int secondDigit, char operationSign) {
        int result = 0;
        switch (operationSign) {
            case '+' -> result =  firstDigit + secondDigit;
            case '-' -> result =  firstDigit - secondDigit;
            case '*' -> result =  firstDigit * secondDigit;
            case '/' -> result =  firstDigit / secondDigit;
            case '%' -> result =  firstDigit % secondDigit;
        }

        return result;
    }
}


