package com.example.stockbacktest.model;

public class StockData {
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    
    // 构造函数、getter和setter方法
    public StockData() {}
    
    public StockData(String date, double open, double high, double low, double close, double volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }
    
    // 生成getter和setter方法（在VS Code中可以用快捷键：Alt+Insert）
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public double getOpen() { return open; }
    public void setOpen(double open) { this.open = open; }
    public double getHigh() { return high; }
    public void setHigh(double high) { this.high = high; }
    public double getLow() { return low; }
    public void setLow(double low) { this.low = low; }
    public double getClose() { return close; }
    public void setClose(double close) { this.close = close; }
    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }
}