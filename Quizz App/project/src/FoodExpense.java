
import java.util.Date;

public class FoodExpense extends Expense {
    private String foodItem;

    public FoodExpense(double amount, Date date, ExpenseCategory category, String foodItem) {
        super(amount, date, category);
        this.foodItem = foodItem;
    }

    public String getFoodItem() {
        return foodItem;
    }

    @Override
    public String getAdditionalDetails() {
        return "Food Item: " + foodItem;
    }
}
