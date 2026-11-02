package AppUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppUI {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void greetings(){
        System.out.println("Welcome to the Financial Tracker App, I hope you are having a wonderful day.");
    }

    public static void theStart(){
        System.out.println("Are you signing in, or signing up with a new user?.");
    }




    public static void askForUserName(){
        System.out.println("Please enter your username: ");
    }
    public static void askForPassword(){
        System.out.println("Please enter your password: ");
    }

    public static void mainMenu(){
        System.out.println("Welcome to the main menu, here are the following options");
        System.out.println("1. Make Entry");
        System.out.println("2. View History");
        System.out.println("3. Look at Total Stars");
        System.out.println("4. Exit");

    }

    public static void makeEntryMenu(){
        System.out.println("Of course, please enter your information: ");
    }

    public static void makeEntryDate(){
        System.out.println("1. Date: ");
    }
    public static void makeEntryIncome(){
        System.out.println("2. Income: ");
    }
    public static void makeEntryExpenses(){
        System.out.println("3. Expenses: ");
    }
    public static void makeEntryPurchases(){
        System.out.println("4. Purchases: cost: ");
    }



    public static void viewHistoryMenu(){
        System.out.println("Of course, I shall reveal history now");
    }

    public static void viewStarsMenu(){
        System.out.println("Of course, I shall reveal your current star count now");
    }

    public static void exitMenu(){
        System.out.println("Very well, thank you for your visit and please come again!");
    }

    public static void reachedGoal(){
        System.out.println("Congratulations! You have reached your goal of $");
    }











}
