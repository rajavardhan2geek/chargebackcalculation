package com.cts.cbc.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cts.cbc.Bo.FundUsersBO;
import com.cts.cbc.Model.FundDetailsDTO;
import com.cts.cbc.Model.StockDetailsDTO;
import com.cts.cbc.Model.UsersOfFundDTO;
import com.cts.cbc.View.FundUserCbcView;

public class FundUserController {
	
	public static void main(String args[]) throws ClassNotFoundException, IOException, SQLException{
		FundUserController.fundUserMenu();
	}
	
	Scanner sc = new Scanner(System.in);
	public static void fundUserMenu() throws ClassNotFoundException, IOException, SQLException{
		int choice;
		String fundId;
		int stockId, noOfStocks;
		FundUsersBO fundUsersBo = new FundUsersBO();
		FundUserCbcView fundUserView = new FundUserCbcView();
		ArrayList<FundDetailsDTO> fundList;
		ArrayList<UsersOfFundDTO> fundUsersList;
		ArrayList<StockDetailsDTO> stockList;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Choice to Buy/Sell Stock for Fund Users");
		System.out.println("1.Buy\n2.Sell");
		
		choice = sc.nextInt();
		
		switch(choice){
		case 1:	fundList = fundUsersBo.getAllFundsListBO();
				fundUserView.displayFundsList(fundList);
				
				System.out.println("Enter the FundId");
				fundId = sc.next();
				
				fundUsersList = fundUsersBo.getFundUsersListByFundIdBO(fundId);
				fundUserView.displayUsersByFundId(fundUsersList);
				
				stockList = fundUsersBo.getAllStocksDetailsBO();
				fundUserView.dipsplyStockDetails(stockList);
				System.out.println("Enter the StockId");
				stockId = sc.nextInt();
				
				System.out.println("Enter the no Of Stocks");
				noOfStocks = sc.nextInt();
				
				fundUsersBo.buyStockforFundUsersBO(fundId, stockId, noOfStocks, fundUsersList);
				
				
				
				
		}
		
	}
	
}
