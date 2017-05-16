package com.cts.cbc.Model;

public class FundDetailsDTO {
	private int fundId;
	private String fundName;

	public void setfundIdByString(String fundId) {
		
		this.fundId = Integer.parseInt(fundId.substring(5));
	}
	public void setfundIdByInt(int fundId) {
		
		this.fundId = fundId;
	}

	public String getfundIdByString() {
		return "FUND0"+Integer.toString(fundId);
	}
	public int getfundIdByInt() {
		return fundId;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundName() {
		return fundName;
	}
	
}
