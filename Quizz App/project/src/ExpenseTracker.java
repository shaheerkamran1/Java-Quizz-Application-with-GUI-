import java.util.List;

public interface ExpenseTracker {
    void addExpense(Expense expense);
    void viewExpenses();
    double getTotalExpenses();
    List<Expense> getExpenses();
}
