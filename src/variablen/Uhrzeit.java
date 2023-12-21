package variablen;

import java.util.Date;
import java.util.Scanner;

public class Uhrzeit {
    static int DAYS_IN_SECONDS = 86400;
    static int HOURS_IN_SECONDS = 3600;
    static int MINUTES_IN_SECONDS = 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Uhrzeit berechnen: ");
        System.out.println("Geben Sie eine Zahl mit mindestens 7 Stellen ein: ");
        String input = sc.nextLine();

        int seconds = Integer.parseInt(input);
        calculateTime(seconds);
    }

    private static void calculateTime(int seconds) {
        int remainingSeconds = seconds;
        int days = getDays(remainingSeconds);
        remainingSeconds = remainingSeconds - days * DAYS_IN_SECONDS;
        int hours = getHours(remainingSeconds);
        remainingSeconds = remainingSeconds - hours * HOURS_IN_SECONDS;
        int minutes = getMinutes(remainingSeconds);
        remainingSeconds = remainingSeconds - minutes * MINUTES_IN_SECONDS;

        showTimeAsText(seconds, days, hours, minutes, remainingSeconds);
    }

    private static int getDays (int seconds) {
        return seconds / DAYS_IN_SECONDS;
    }

    private static int getHours(int seconds) {
        return seconds / HOURS_IN_SECONDS;
    }

    private static int getMinutes(int seconds) {
        return seconds / MINUTES_IN_SECONDS;
    }

    private static void showTimeAsText(int seconds, int days, int hours, int minutes, int remainingSeconds) {
        System.out.printf("%d entspricht %d Tage, %d Stunden %d Minuten %d Sekunden", seconds, days, hours, minutes, remainingSeconds);
    }
}
