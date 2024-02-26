
public enum ExpenseCategory {
    FOOD("Food"),
    ENTERTAINMENT("Entertainment"),
    TRANSPORTATION("Transportation"),
    OTHER("Other");

    private final String categoryName;

    ExpenseCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
