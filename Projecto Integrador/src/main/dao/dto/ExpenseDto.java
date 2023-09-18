package main.dao.dto;

public class ExpenseDto {
    private int expense_id;
    private int user_key;
    private int category_key;
    private double amount;
    private String date;

    public ExpenseDto() {}

    public ExpenseDto(int user_key, int category_key, double amount, String date) {
        this.user_key = user_key;
        this.category_key = category_key;
        this.amount = amount;
        this.date = date;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public int getUser_key() {
        return user_key;
    }

    public void setUser_key(int user_key) {
        this.user_key = user_key;
    }

    public int getCategory_key() {
        return category_key;
    }

    public void setCategory_key(int category_key) {
        this.category_key = category_key;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
