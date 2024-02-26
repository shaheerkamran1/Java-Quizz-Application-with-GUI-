
import java.util.Date;

public class EntertainmentExpense extends Expense {
    private String description;

    public EntertainmentExpense(double amount, Date date, ExpenseCategory category, String description) {
        super(amount, date, category);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getAdditionalDetails() {
        return "Description: " + description;
    }
}
