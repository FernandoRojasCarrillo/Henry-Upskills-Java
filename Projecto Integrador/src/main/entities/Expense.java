package main.entities;

public class Expense {
    private double amount;
    private String date;

    public Expense() {}

    public Expense(double amount, String date) {
        this.amount = amount;
        this.date = date;
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

    @Override
    public String toString() {
        return "Expense { " +
                "amount = " + amount +
                ", date = " + date +" }";
    }
 }
