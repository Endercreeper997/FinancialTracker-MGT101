package Users_and_Goals;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class User {
    //region
    /*
    Stored information
        Username
        Password
        Current Held Amount of money
        Financial history array
        Gold star count
        Financial goal object
     */

    //endregion

    // variables
    private long userID;
    private String username;
    private String password;
    private BigDecimal balance; //up to 2 decimals
    private List<String> history = new ArrayList<>();
    private int goldStars;
    private FinancialGoal currentGoal;

    // constructors, only used when creating a new user

    public User(String username, String password, float balance)
    {
        setUsername(username);
        setPassword(password);
        setBalance(balance);
        setGoldStars(0);
        setCurrentGoal(null);
    }
    public User(String username, String password)
    {
        setUsername(username);
        setPassword(password);
        setBalance(0.0f);
        setGoldStars(0);
        setCurrentGoal(null);
    }

    //TODO: reimplement default constructor

    //region Gets and Sets


    public long getUserID() {
        return this.userID;
    }

    private void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.isEmpty() || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null, empty or blank");
        }
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        if (password == null || password.isEmpty() || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null, empty or blank");
        }
        this.password = password;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    private void setBalance(float balance) {
        BigDecimal decimalFl = new BigDecimal(balance).setScale(2, RoundingMode.HALF_EVEN);
        this.balance = decimalFl;
    }

    public List<String> getHistory() {
        return this.history;
    }

    private void setHistory(List<String> history) {
        if (history == null) {
            throw new IllegalArgumentException("Financial History cannot be null");
        }
        this.history = history;
    }

    public int getGoldStars() {
        return this.goldStars;
    }

    private void setGoldStars(int goldStars) {
        this.goldStars = goldStars;
    }

    public FinancialGoal getCurrentGoal() {
        return this.currentGoal;
    }

    private void setCurrentGoal(FinancialGoal currentGoal) {
        if(currentGoal == null) {
            this.currentGoal = new FinancialGoal();
        }else {
            this.currentGoal = currentGoal;
        }
    }


    //endregion


    //region Functions
    //TODO: implement a function that penalizes going into the negatives in your balance. Like a true banking app heheh

    //user verification, username and password must be exact.
    public boolean userNameVerify(String input)
    {
        return input == this.getUsername();
    }
    public boolean passwordVerify(String input)
    {
        return input == this.getPassword();
    }

    public boolean userVerify(String uInput, String pInput)
    {
        boolean validUser = false;
        boolean validUsername = userNameVerify(uInput);
        if(validUsername)
        {
            boolean validPassword = passwordVerify(pInput);
            if(validPassword)
            {
                validUser = true;
            }else{
                System.out.println("Password is incorrect");
            }
        }else{
            System.out.println("Username is incorrect");
        }
        return validUser;
    }

    //endregion

    //Overrides


    @Override
    public String toString() {
        return "User " + getUserID() + "\nUsername: " + getUsername() + "\nBalance: " + getBalance() + "$\nGold Star Count: " + getGoldStars();
    }
}
