package Financial_History;

import Users_and_Goals.User;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import AppUI.AppUI;
import Edward.HelperPrompts;
import Users_and_Goals.UserDatabase;


public class FinancialApp {

    static UserDatabase ud = new UserDatabase();
    public static void promptUser(){
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

    public static void mainMenuAppear(User user){
        AppUI.mainMenu();
        int input = HelperPrompts.promptForInt(1, 4);
        switch (input){
            case 1:
                entryMenu(user);
                break;
            case 2:
                AppUI.viewHistoryMenu();
                printHistory(user);
                break;
            case 3:
                AppUI.viewStarsMenu();
                int stars = user.getGoldStars();
                System.out.println("Stars: " + stars);
                mainMenuAppear(user);
                break;
            case 4:
                AppUI.exitMenu();
                break;
        }
    }

    public static void entryMenu(User user){
        HistoryClass.EntryType type;
        BigDecimal bigDecAmount;
        String desc;
        AppUI.makeEntryMenu();

        AppUI.makeEntryDate();
        String date = HelperPrompts.promptForInput();
        LocalDate realDate = LocalDate.parse(date);

        AppUI.makeEntryIncome();
        float income = HelperPrompts.promptForFloat(0.0f, 1000.0f);
        user.increaseBalance(income);

        AppUI.makeEntryExpenses();
        float expenses = HelperPrompts.promptForFloat(0.0f, 1000.0f);
        user.decreaseBalance(expenses);

        AppUI.makeEntryPurchases();
        String purchases = HelperPrompts.promptForInput();

        if(expenses > 0){
            if(purchases.equalsIgnoreCase("None")
                    || purchases.equalsIgnoreCase("N/A")
                    || purchases.equalsIgnoreCase("No Purchases")){
                type = HistoryClass.EntryType.EXPENSE;
                desc = "Daily Expenses";
            } else{
                type = HistoryClass.EntryType.PURCHASE;
                desc = "Groceries";
            }
            bigDecAmount = BigDecimal.valueOf(-expenses);
        } else {
            type = HistoryClass.EntryType.INCOME;
            desc = "Job Income";
            bigDecAmount = BigDecimal.valueOf(+income);
        }

        HistoryClass entry = new HistoryClass(realDate, type, bigDecAmount, desc);
        addEntry(user, entry);

        possibleReward(user);
        mainMenuAppear(user);
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

    // Records an entry and updates the user's balance
    public static void addEntry(User user, HistoryClass entry) {
        user.getHistory().add(entry);              // needs List<HistoryClass>
        user.adjustBalance(entry.getSignedAmount()); // needs the new User method
    }

    public static void printHistory(User user) {
        List<HistoryClass> history = user.getHistory();
        if (history.isEmpty()) {
            System.out.println("No history yet.");
            return;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }

        mainMenuAppear(user);
    }

    public static BigDecimal totalByType(User user, HistoryClass.EntryType type) {
        BigDecimal total = BigDecimal.ZERO;
        for (HistoryClass h : user.getHistory()) {
            if (h.getType() == type) {
                total = total.add(h.getAmount());
            }
        }
        return total;
    }

    // Everything linked to a particular goal, for tracking progress
    public static BigDecimal totalForGoal(User user, Users_and_Goals.FinancialGoal goal) {
        BigDecimal total = BigDecimal.ZERO;
        for (HistoryClass h : user.getHistory()) {
            if (h.getGoal() == goal) {
                total = total.add(h.getSignedAmount());
            }
        }
        return total;
    }
}