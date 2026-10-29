package Financial_History;

import AppUI.AppUI;
import Edward.HelperPrompts;
import Users_and_Goals.User;
import Users_and_Goals.UserDatabase;

public class FinancialApp {

    static AppUI appUI = new AppUI();
    UserDatabase ud = new UserDatabase();
public void promptUser(){
    boolean invalidUser = false;

    AppUI.greetings();
    AppUI.theStart();
    boolean signInOrUp = HelperPrompts.promptForBool("signing in", "signing up");
    AppUI.askForUserName();
    String user = HelperPrompts.promptForInput();
    AppUI.askForPassword();
    String pass = HelperPrompts.promptForInput();
    if(signInOrUp){
        User person;
        do {
            person = ud.checkAllUsersLogin(user, pass);
            if(person == null){
                invalidUser = true;
                System.out.println("Either your username or password is incorrect.");
            } else {
                invalidUser = false;
            }
        } while (invalidUser);
        mainMenuAppear(person);
    }
    else {
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
            entryMenu(user);
            break;
        case 2:
            AppUI.viewHistoryMenu();
            //TODO: Call History Class functions
            break;
        case 3:
            AppUI.viewStarsMenu();
            int stars = user.getGoldStars();
            System.out.println("Stars: " + stars);
            break;
        case 4:
            AppUI.exitMenu();
            break;
    }
}

public void entryMenu(User user){
    AppUI.makeEntryMenu();

    AppUI.makeEntryDate();
    String date = HelperPrompts.promptForInput();

    AppUI.makeEntryIncome();
    float income = HelperPrompts.promptForFloat(0.0f, 1000.0f);
    user.increaseBalance(income);

    AppUI.makeEntryExpenses();
    float expenses = HelperPrompts.promptForFloat(0.0f, 1000.0f);
    user.decreaseBalance(expenses);

    AppUI.makeEntryPurchases();
    String purchases = HelperPrompts.promptForInput();

    //TODO: Make a History Ticket

    possibleReward(user);
}

public static boolean checkForGoal(){
    int totalIncome = 5; //Temp vals - remove once there is a total income form history class
    int goal = 8; //Temp vals - same as the comment right above this one
    if(totalIncome >= goal) {
        return true;
    }else{
        return false;
    }
}

public static void possibleReward(User user){
    if(checkForGoal()){
        AppUI.reachedGoal();
        //user.increaseStarCount(1);
    }
}

}
