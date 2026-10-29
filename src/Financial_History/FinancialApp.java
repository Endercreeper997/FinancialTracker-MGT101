package Financial_History;

import AppUI.AppUI;
import Edward.HelperPrompts;
import Users_and_Goals.User;
import Users_and_Goals.UserDatabase;

public class FinancialApp {

    static AppUI appUI = new AppUI();
    UserDatabase ud = new UserDatabase();
public void promptUser(){
    AppUI.greetings();
    AppUI.theStart();
    boolean signInOrUp = HelperPrompts.promptForBool("signing in", "signing up");
    if(signInOrUp){
        AppUI.askForUserName();
        String user = HelperPrompts.promptForInput();
        AppUI.askForPassword();
        String pass = HelperPrompts.promptForInput();

        User person = ud.checkAllUsersLogin(user, pass);
        mainMenuAppear(person);
    }
    else {
        AppUI.askForUserName();
        String user = HelperPrompts.promptForInput();
        AppUI.askForPassword();
        String pass = HelperPrompts.promptForInput();

        User person = new User(user, pass);
        ud.addUser(person);
        mainMenuAppear(person);
    }
}

public void mainMenuAppear(User user){
    AppUI.mainMenu();
    int input = HelperPrompts.promptForInt(1, 4);
    switch (input){
        case 1:
            break;
        case 2:
            break;
        case 3:
            AppUI.viewStarsMenu();
            int stars = user.getGoldStars();
            break;
        case 4:
            AppUI.exitMenu();
            break;
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
