package Financial_History;

import AppUI.AppUI;
import Edward.HelperPrompts;
import Users_and_Goals.User;

public class FinancialApp {

    static AppUI appUI = new AppUI();
public void promptUser(){
    AppUI.greetings();
    AppUI.theStart();
    boolean signInOrUp = HelperPrompts.promptForBool("signing in", "signing up");
    if(signInOrUp){
        AppUI.askForUserName();
        String user = HelperPrompts.promptForInput();
        AppUI.askForPassword();
        String pass = HelperPrompts.promptForInput();


    }
}





















/*public static boolean checkForGoal(){
    int totalIncome = 5; //remove once there is a total income form history class
    int goal = 8; //same as the comment right above this one
    if(totalIncome >= goal) {
        return true;
    }else{
        return false;
    }
}

public static void possibleReward(){
    checkForGoal();
    if(checkForGoal()){
        appUI.reachedGoal();
    }
}

public static void revealStars(){
    appUI.viewStarsMenu();
}   */



}
