import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenseTrackerApp {
    private ExpenseTracker expenseTracker;
    private JFrame frame;
    private JButton addExpenseButton;
    private JButton viewExpensesButton;
    private JButton calculateTotalButton;

    public ExpenseTrackerApp() {
        expenseTracker = new DailyExpenseTracker();

        frame = new JFrame("Expense Tracker App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addExpenseButton = new JButton("Add Expense");
        viewExpensesButton = new JButton("View Expenses");
        calculateTotalButton = new JButton("Calculate Total Expenses");

        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddExpenseDialog();
            }
        });

        viewExpensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showViewExpensesDialog();
            }
        });

        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalExpenses();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(addExpenseButton);
        panel.add(viewExpensesButton);
        panel.add(calculateTotalButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showAddExpenseDialog() {
        String[] categories = { "Food", "Entertainment", "Transportation", "Other" };
        String selectedCategory = (String) JOptionPane.showInputDialog(frame,
                "Select the category:", "Add Expense",
                JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);

        if (selectedCategory != null) {
            String amountString = JOptionPane.showInputDialog(frame, "Enter the amount:");
            if (amountString != null && !amountString.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountString);
                    String dateString = JOptionPane.showInputDialog(frame, "Enter the date (MM/DD/YYYY):");
                    if (dateString != null && !dateString.isEmpty()) {
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            Date date = dateFormat.parse(dateString);

                            if (selectedCategory.equals("Food")) {
                                String foodItem = JOptionPane.showInputDialog(frame, "Enter the food item:");
                                Expense expense = new FoodExpense(amount, date, ExpenseCategory.FOOD, foodItem);
                                expenseTracker.addExpense(expense);
                                JOptionPane.showMessageDialog(frame, "Expense added successfully!");
                            } else if (selectedCategory.equals("Entertainment")) {
                                String entertainmentDescription = JOptionPane.showInputDialog(frame, "Enter the entertainment description:");
                                Expense expense = new EntertainmentExpense(amount, date, ExpenseCategory.ENTERTAINMENT, entertainmentDescription);
                                expenseTracker.addExpense(expense);
                                JOptionPane.showMessageDialog(frame, "Expense added successfully!");
                            } else {
                                ExpenseCategory category = ExpenseCategory.valueOf(selectedCategory.toUpperCase());
                                Expense expense = new Expense(amount, date, category) {
                                    @Override
                                    public String getAdditionalDetails() {
                                        return "";
                                    }
                                };
                                expenseTracker.addExpense(expense);
                                JOptionPane.showMessageDialog(frame, "Expense added successfully!");
                            }
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid date format. Please use MM/DD/YYYY.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount format. Please enter a valid number.");
                }
            }
        }
    }

    private void showViewExpensesDialog() {
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textArea.append("Expense List:\n");
        for (Expense expense : expenseTracker.getExpenses()) {
            textArea.append(expense.toString() + "\n");
        }

        JOptionPane.showMessageDialog(frame, scrollPane, "View Expenses", JOptionPane.PLAIN_MESSAGE);
    }

    private void calculateTotalExpenses() {
        double totalExpenses = expenseTracker.getTotalExpenses();
        JOptionPane.showMessageDialog(frame, "Total Expenses: $" + totalExpenses);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpenseTrackerApp();
            }
        });
    }
}
