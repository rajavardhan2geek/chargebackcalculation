package com.cts.cbc.Model;

public class UsersOfFundDTO {
	private int trsactionId;
	private String name;
	private int userId;
	private double balanceAmountLeft;
	private int stockId;
	private int noOfStocks;
	private int fundId;

	
	

	public void setTrsactionId(int trsactionId) {
		this.trsactionId = trsactionId;
	}
	public String getTrsactionId() {
		return "TRANS0"+Integer.toString(trsactionId);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setUserIdByString(String userId) {
		this.userId = Integer.parseInt(userId.substring(5));
	}
	public void setUserIdByInt(int userId) {
		this.userId = userId;
	}
	public String getUserIdByString() {
		return "USER0"+Integer.toString(userId);
	}
	public int getUserIdByInt() {
		return userId;
	}
	public void setBalanceAmountLeft(double balanceAmountLeft) {
		this.balanceAmountLeft = balanceAmountLeft;
	}
	public double getBalanceAmountLeft() {
		return balanceAmountLeft;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	public int getNoOfStocks() {
		return noOfStocks;
	}
	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	public int getFundId() {
		return fundId;
	}

}
