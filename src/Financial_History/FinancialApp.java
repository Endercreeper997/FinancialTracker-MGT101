package Financial_History;

import Users_and_Goals.User;
import java.math.BigDecimal;
import java.util.List;

public class FinancialApp {

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

    // Since Users_and_Goals.FinancialGoal is empty for now, this just compares references.
    // Once a target amount is added, check this function against it to trigger AppUi.reachedGoal()
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