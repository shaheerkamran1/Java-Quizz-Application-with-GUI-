
import java.util.Date;

public abstract class Expense {
    protected double amount;
    protected Date date;
    protected ExpenseCategory category;
  
    public Expense(double amount, Date date, ExpenseCategory category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public abstract String getAdditionalDetails();

    @Override
    public String toString() {
        return "Amount: $" + amount +", Date: " + date + ", Category: " + category.getCategoryName() +  ", " + getAdditionalDetails();
    }
}
