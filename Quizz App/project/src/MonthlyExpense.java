import java.util.ArrayList;
import java.util.List;

public class MonthlyExpense implements ExpenseTracker {
    private List<Expense> monthlyExpenseList;

    public MonthlyExpense() {
        monthlyExpenseList = new ArrayList<>();
    }

    @Override
    public void addExpense(Expense expense) {
        monthlyExpenseList.add(expense);
    }

    @Override
    public void viewExpenses() {
        System.out.println("Monthly Expense List:");
        for (Expense expense : monthlyExpenseList) {
            System.out.println(expense.toString());
        }
    }

    @Override
    public double getTotalExpenses() {
        double totalExpenses = 0.0;
        for (Expense expense : monthlyExpenseList) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }

    @Override
    public List<Expense> getExpenses() {
        return monthlyExpenseList;
    }
}
