package Edward;

import java.io.BufferedReader;
//import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperPrompts {
    public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static int promptForInt(String prompt, int max, int min) {
        boolean invalidInput = true;
        String input = "";
        int userNum = 0;
        do {
            System.out.println(prompt);
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForInt");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
                continue;
            }

            userNum = Integer.parseInt(input);

            if (userNum > max || userNum < min) {
                System.out.println("That input is invalid. Please try again.");
            } else{
                invalidInput = false;
            }

        } while (invalidInput);

        return userNum;
    }

    public static float promptForFloat(String prompt){
        boolean invalidInput = true;
        String input = "";
        do {
            System.out.println(prompt);
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForFloat");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
            } else{
                invalidInput = false;
            }

        } while (invalidInput);

        return Float.parseFloat(input);
    }

    public static boolean promptForBool(String prompt, String trueString, String falseString){
        boolean invalidInput = true;
        String input = "";
        boolean returnBool = false;
        do {
            System.out.println(prompt);
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForFloat");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
            } else if(input.equalsIgnoreCase(trueString)){
                returnBool = true;
                invalidInput = false;
            } else if (input.equalsIgnoreCase(falseString)) {
                returnBool = false;
                invalidInput = false;
            } else{
                System.out.println("That input is invalid, please try again.");
            }

        } while (invalidInput);


        return returnBool;
    }

    public static String promptForInput(String prompt){
        boolean invalidInput = true;
        String input = "";
        do {
            System.out.println(prompt);
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForFloat");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
            } else{
                invalidInput = false;
            }

        } while (invalidInput);

        return input;
    }
}
