package com.cts.cbc.Model;

public class FundUserTransactionDTO {
	private int stockId;
	private int userId;
	private float sotckPricePerUnit;
	private float amountInvested;
	private float chargeBackInNative;
	private float chargeBackInUSD;
	private String role;
	private String description;
	private int noOfDaysHeld;
	private float availableBalInNative;
	private float availableBalInUSD;
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setUsedId(int usedId) {
		this.userId = usedId;
	}
	public int getUsedId() {
		return userId;
	}
	public void setSotckPricePerUnit(float sotckPricePerUnit) {
		this.sotckPricePerUnit = sotckPricePerUnit;
	}
	public float getSotckPricePerUnit() {
		return sotckPricePerUnit;
	}
	public void setAmountInvested(float amountInvested) {
		this.amountInvested = amountInvested;
	}
	public float getAmountInvested() {
		return amountInvested;
	}
	public void setChargeBackInNative(float chargeBackInNative) {
		this.chargeBackInNative = chargeBackInNative;
	}
	public float getChargeBackInNative() {
		return chargeBackInNative;
	}
	public void setChargeBackInUSD(float chargeBackInUSD) {
		this.chargeBackInUSD = chargeBackInUSD;
	}
	public float getChargeBackInUSD() {
		return chargeBackInUSD;
	}
	public void setRole(String role) {
		this.role = "FUND";
	}
	public String getRole() {
		return role;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setNoOfDaysHeld(int noOfDaysHeld) {
		this.noOfDaysHeld = noOfDaysHeld;
	}
	public int getNoOfDaysHeld() {
		return noOfDaysHeld;
	}
	public void setAvailableBalInNative(float availableBalInNative) {
		this.availableBalInNative = availableBalInNative;
	}
	public float getAvailableBalInNative() {
		return availableBalInNative;
	}
	public void setAvailableBalInUSD(float availableBalInUSD) {
		this.availableBalInUSD = availableBalInUSD;
	}
	public float getAvailableBalInUSD() {
		return availableBalInUSD;
	}
	

}
