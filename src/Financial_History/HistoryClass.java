package Financial_History;

import Users_and_Goals.FinancialGoal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class HistoryClass {


    public enum EntryType { INCOME, EXPENSE, PURCHASE }

    private LocalDate date;
    private EntryType type;
    private BigDecimal amount;        // always stored positive
    private String description;
    private FinancialGoal goal;       // optional link, may be null

    public HistoryClass(LocalDate date, EntryType type, BigDecimal amount,
                        String description, FinancialGoal goal) {
        setDate(date);
        setType(type);
        setAmount(amount);
        setDescription(description);
        this.goal = goal;
    }

    public HistoryClass(LocalDate date, EntryType type, BigDecimal amount, String description) {
        this(date, type, amount, description, null);
    }

    //region Gets and Sets
    public LocalDate getDate() { return date; }
    private void setDate(LocalDate date) {
        if (date == null) throw new IllegalArgumentException("Date cannot be null");
        this.date = date;
    }

    public EntryType getType() { return type; }
    private void setType(EntryType type) {
        if (type == null) throw new IllegalArgumentException("Type cannot be null");
        this.type = type;
    }

    public BigDecimal getAmount() { return amount; }
    private void setAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.amount = amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getDescription() { return description; }
    private void setDescription(String description) {
        this.description = (description == null) ? "" : description;
    }

    public FinancialGoal getGoal() { return goal; }
    public void setGoal(FinancialGoal goal) { this.goal = goal; }
    //endregion

    // Income adds to the balance, everything else subtracts
    public BigDecimal getSignedAmount() {
        return type == EntryType.INCOME ? amount : amount.negate();
    }

    @Override
    public String toString() {
        String sign = type == EntryType.INCOME ? "+" : "-";
        String goalText = (goal == null) ? "" : " [linked to goal]";
        return date + " | " + type + " | " + sign + "$" + amount + " | " + description + goalText;
    }
}