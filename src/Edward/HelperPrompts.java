package Edward;

import java.io.BufferedReader;
//import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperPrompts {
    public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static int promptForInt(int min, int max) {
        boolean invalidInput = true;
        String input = "";
        do {
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForInt");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
            } else{
                int intIn = Integer.parseInt(input);
                if(intIn > max || intIn < min){
                    System.out.println("That input is above the max or below the min. Please try again.");
                } else{
                    invalidInput = false;
                }
            }

        } while (invalidInput);

        return Integer.parseInt(input);
    }

    public static float promptForFloat(float min, float max){
        boolean invalidInput = true;
        String input = "";
        do {
            try {
                input = read.readLine();
            } catch (IOException e) {
                System.out.println("IOException - PromptForFloat");
            }

            if (input == null || input.isBlank()) {
                System.out.println("That input is invalid. Please try again.");
            } else{
                float floatIn = Float.parseFloat(input);
                if(floatIn > max || floatIn < min){
                    System.out.println("That input is above the max or below the min. Please try again.");
                } else {
                    invalidInput = false;
                }
            }

        } while (invalidInput);

        return Float.parseFloat(input);
    }

    public static boolean promptForBool(String trueString, String falseString){
        boolean invalidInput = true;
        String input = "";
        boolean returnBool = false;
        do {
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

    public static String promptForInput(){
        boolean invalidInput = true;
        String input = "";
        do {
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
