import javax.swing.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyExpenseTracker implements ExpenseTracker {
    private List<Expense> dailyExpenseList;

    public DailyExpenseTracker() {
        dailyExpenseList = new ArrayList<>();
    }

    @Override
    public void addExpense(Expense expense) {
        dailyExpenseList.add(expense);
    }

    @Override
    public void viewExpenses() {
        System.out.println("Daily Expense List:");
        System.out.println("+-------------------+----------------+-----------+------------------------+");
        System.out.println("| Date              | Category       | Amount    | Additional Details     |");
        System.out.println("+-------------------+----------------+-----------+------------------------+");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for (Expense expense : dailyExpenseList) {
            System.out.printf("| %-17s | %-14s | $%-8.2f | %-22s |\n",
                    dateFormat.format(expense.getDate()),
                    expense.getCategory(),
                    expense.getAmount(),
                    expense.getAdditionalDetails());
        }
        System.out.println("+-------------------+----------------+-----------+------------------------+");
        calculateAndShowTotalExpenses();
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

    private void calculateAndShowTotalExpenses() {
        double totalExpenses = getTotalExpenses();
        Map<ExpenseCategory, Double> categoryTotals = new HashMap<>();

        for (Expense expense : dailyExpenseList) {
            categoryTotals.put(expense.getCategory(), categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        StringBuilder totalExpensesMessage = new StringBuilder();
        totalExpensesMessage.append("Total Expenses: $").append(decimalFormat.format(totalExpenses)).append("\n");
        totalExpensesMessage.append("Expense Breakdown:\n");
        for (Map.Entry<ExpenseCategory, Double> entry : categoryTotals.entrySet()) {
            totalExpensesMessage.append(entry.getKey()).append(": $").append(decimalFormat.format(entry.getValue())).append("\n");
        }

        JOptionPane.showMessageDialog(null, totalExpensesMessage.toString(), "Total Expenses", JOptionPane.INFORMATION_MESSAGE);
    }
}
