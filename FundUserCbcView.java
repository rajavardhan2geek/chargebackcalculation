package com.cts.cbc.View;

import java.util.ArrayList;


import com.cts.cbc.Bo.FundUsersBO;
import com.cts.cbc.Model.FundDetailsDTO;
import com.cts.cbc.Model.StockDetailsDTO;
import com.cts.cbc.Model.UsersOfFundDTO;

public class FundUserCbcView {
	
	FundUsersBO fundUsersBO = new FundUsersBO();
	
	
	public void displayFundsList(ArrayList<FundDetailsDTO> fundsList){
		
		System.out.println("The Following are Available Fund Groups");
		System.out.println(" FUNDID"+"    "+"  FUNDNAME");
		System.out.println("---------    ----------");
		for (FundDetailsDTO fundDetailsDTO : fundsList) {
			System.out.println(fundDetailsDTO.getfundIdByString()+"       "
					+fundDetailsDTO.getFundName());
			
		}
		
	}
	public void displayUsersByFundId(ArrayList<UsersOfFundDTO> usersList){
		
		
		System.out.println("NAME    USERID    BAL.AMOUNT");
		System.out.println("-----  ---------  ----------");
		for (UsersOfFundDTO usersOfFundDTO : usersList) {
			System.out.println(usersOfFundDTO.getName()+"    "+
					usersOfFundDTO.getUserIdByString()+"     "+usersOfFundDTO.getBalanceAmountLeft());
		}
	}
	public void dipsplyStockDetails(ArrayList<StockDetailsDTO> stockList){
		System.out.println("STOCKID    STOCKNAME    STOCKPRICE");
		System.out.println("------    -----------   -----------");
		for (StockDetailsDTO stockDetailsDTO : stockList) {
			System.out.println(stockDetailsDTO.getStockId()+"          "+stockDetailsDTO.getSotckName()+
					"            "+stockDetailsDTO.getStockPrice());
		}
	}

}
