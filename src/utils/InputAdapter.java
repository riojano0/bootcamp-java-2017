package utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Daniel on 10/01/2017.
 */
public class InputAdapter {

    public static Date InputScannerDate(String message, String errorMessage){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message+" ");
            try {
                return DateAdapter.dateFormat(sc.nextLine());
            }
            catch (NumberFormatException e){
                System.out.print(errorMessage+"\n");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static int InputScannerInteger(String message, String errorMessage){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message+" ");
            try {
                return Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e){
                System.out.print(errorMessage+"\n");
            }
        }
    }

    public static int InputScannerInteger(String message, String errorMessage,int firstValue,int endValue){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(message+" ");
            try {
               int input = Integer.parseInt(sc.nextLine());
               if (input <= endValue && input>=firstValue ) {
                    return input;
                } else {
                    System.out.print(errorMessage+"\n");

                }
            }
            catch (NumberFormatException e){
                System.out.print(errorMessage+"\n");
            }
        }
    }

    public static double InputScannerDouble(String message, String errorMessage){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message+" ");
            try {
                return Double.parseDouble(sc.nextLine());
            }
            catch (NumberFormatException e){
                System.out.print(errorMessage+"\n");
            }
        }
    }

    public static String InputScanner(String message, String errorMessage){
        Scanner sc = new Scanner(System.in);
              while (true) {
                System.out.print(message+" ");
                String input = sc.nextLine();
                if (input.length() > 0) {
                    return input;
                } else {
                    System.out.print(errorMessage+"\n");

                }
            }
    }

    public static String InputScanner(String message, String errorMessage, int firstValue, int endValue){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message+" ");
            String input = sc.nextLine();
            if (input.length() <= endValue && input.length()>=firstValue ) {
                return input;
            } else {
                System.out.print(errorMessage+"\n");

            }
        }
    }

}
