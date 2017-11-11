package com.algorithm.drill.day5.paixu;

import java.util.Scanner;

public class YearsToKnow {

    public static void main(String[] args) {
        System.out.println("Please Input A Year As An Integer Number：");
        int year = scannerYear();

        System.out.print("The year of " + year + " is ");
        System.out.print(isLeapYear(year) ? "" : "not ");
        System.out.println("a leap year");
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static boolean isOutofRange(int year) {
        return year > 99999 || year < -10000;
    }

    private static int scannerYear() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!str.matches("^-?[1-9][0-9]*$")) {
            System.out.println("Not an Integer Number！Input Again：");
            return scannerYear();
        } else {
            int year = Integer.parseInt(str);
            if (isOutofRange(year)) {
                System.out.println("Unusual year！Another please：");
                return scannerYear();
            }
            return year;
        }
    }

}
