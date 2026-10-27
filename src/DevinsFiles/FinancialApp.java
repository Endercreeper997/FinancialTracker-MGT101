package DevinsFiles;

import Users_and_Goals.User;

import java.util.ArrayList;

import static DevinsFiles.AppUI.*;
import static Edward.HelperPrompts.*;
//import static Users_and_Goals.User.*;

public class FinancialApp {
    public static void VarifyUserPass(){
        greetings();
        ArrayList<User> users = new ArrayList<>();

        boolean preAccount = promptForBool("Do you have a pre-existing account?", "yes", "no");

        if(!preAccount) {
            System.out.println("Then let us set you up with one!");

            askForUserName();
            String user = promptForInput("");
            askForPassword();
            String pass = promptForInput("");

            User newUser = new User(user, pass);
            users.add(newUser);

            showMainMenu(newUser);
        } else {
            //TODO - Add Logic to check for pre-existing users
            askForUserName();
            String user = promptForInput("");
            askForPassword();
            String pass = promptForInput("");

            for(User use : users){
                if(user.equals(use.getUsername()) && pass.equals(use.getPassword())){
                    showMainMenu(use);
                }
                else {
                    System.out.println("Incorrect Username or Password, please try again.\n");
                }
            }
        }
    }

    public static void showMainMenu(User user){
        mainMenu();
        int input = promptForInt("", 4, 1);
        switch (input){
            case 1:
                makeEntryMenu();
                getEntryInput();
                break;
            case 2:
                viewHistoryMenu();
                break;
            case 3:
                viewStarsMenu();
                int goldStars = user.getGoldStars();
                System.out.println("Gold star count: " + goldStars);
                break;
            case 4:
                System.out.println("Okay, Have a good day!");
                break;
            default:
                System.out.println("how did you even get here");
        }
    }

    public static void getEntryInput(){

    }
}
