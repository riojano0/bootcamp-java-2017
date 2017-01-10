package utils;

import java.util.Scanner;

/**
 * Created by Daniel on 10/01/2017.
 */
public class InputAdapter {

    private InputAdapter(){}

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
