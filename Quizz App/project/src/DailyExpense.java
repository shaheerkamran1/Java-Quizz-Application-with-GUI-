
import java.util.ArrayList;
import java.util.List;

public class DailyExpense implements ExpenseTracker {
    private List<Expense> dailyExpenseList;

    public DailyExpense() {
        dailyExpenseList = new ArrayList<>();
    }

    @Override
    public void addExpense(Expense expense) {
        dailyExpenseList.add(expense);
    }

    @Override
    public void viewExpenses() {
        System.out.println("Daily Expense List:");
        for (Expense expense : dailyExpenseList) {
            System.out.println(expense.toString());
        }
    }

    @Override
    public double getTotalExpenses() {
        double totalExpenses = 0.0;
        for (Expense expense : dailyExpenseList) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }

    @Override
    public List<Expense> getExpenses() {
        return dailyExpenseList;
    }
}
