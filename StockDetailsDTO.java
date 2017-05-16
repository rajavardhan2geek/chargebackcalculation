package com.cts.cbc.Model;

public class StockDetailsDTO {
	private int stockId;
	private String sotckName;
	private float stockPrice;
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setSotckName(String sotckName) {
		this.sotckName = sotckName;
	}
	public String getSotckName() {
		return sotckName;
	}
	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}
	public float getStockPrice() {
		return stockPrice;
	}
}
