package arrays;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class MesswerteUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wie viele Temperaturwerte möchten Sie abspeichern?: ");
        String temp = sc.next();
        int arraySize = Integer.parseInt(temp); 
        
        double[] temperatureList = new double[arraySize];

        System.out.println("Geben Sie entsprechende Werte in Celsius ein: ");
        for (int i=0; i<temperatureList.length; i++) {
            String temperature = sc.next();
            temperatureList[i] = Double.parseDouble(temperature);
        }

        System.out.println("Die gespeicherten Werte sind: ");
        for (double temperature : temperatureList) {
            System.out.println(temperature);
        }

        DoubleSummaryStatistics stat = Arrays.stream(temperatureList).summaryStatistics();
        double average = stat.getAverage();
        double max = stat.getMax();
        double min = stat.getMin();

        System.out.println("Durschnitt aller Werte: " + average);
        System.out.println("Größte Messwert: " + max);
        System.out.println("Kleinste Messwert: " + min);

        sc.close();
    }

    private static double[] generateTemperatureList(double min, double max) {
        double[] temperatureList = new double[364];
        for (int i=0; i<temperatureList.length; i++) {
            double randomNumber = Math.random() * (max - (min)) + min;
            temperatureList[i] = randomNumber;
        }

        return temperatureList;
    }

    private static double[] calculateWeeksAverageTemperature(double[] temperatureList) {
        double[] averageTemperatures = new double[temperatureList.length / 7];
        int position = 0;

        for (int i=0; i<temperatureList.length; i++) {
            if((i+1) % 7 == 0) {
                double[] weeksTemperature = Arrays.copyOfRange(temperatureList, i, i+7 );
                double sum = 0;
                for (double daysTemperature : weeksTemperature) {
                    sum += daysTemperature;
                }

                double average = sum / 7;
                averageTemperatures[position++] = average;
            }
        }

        return averageTemperatures;
    }
}
