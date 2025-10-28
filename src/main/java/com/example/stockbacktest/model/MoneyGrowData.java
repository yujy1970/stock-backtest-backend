package com.example.stockbacktest.model;

public class MoneyGrowData {
    private String date;
    private double value;
    
    public MoneyGrowData() {}
    
    public MoneyGrowData(String date, double value) {
        this.date = date;
        this.value = value;
    }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}