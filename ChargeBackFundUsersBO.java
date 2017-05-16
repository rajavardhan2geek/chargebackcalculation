package com.cts.cbc.Bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cts.cbc.Dao.StockDetailsDAO;
import com.cts.cbc.Model.FundUserTransactionDTO;
import com.cts.cbc.Model.UsersOfFundDTO;

public class ChargeBackFundUsersBO {

	public float getTotalChargeBack(float totalPrice){
		CommisionratesBO commission = new CommisionratesBO();
		float chargeBack;
		chargeBack = totalPrice * commission.getCommissionRateforSelling(totalPrice);
		System.out.println("Total charge Back "+chargeBack);
		return chargeBack;
	}

	public float getIndividualChargeBackInUSD(float invstedAmnt, float totalPrice){
		float result;
		result = ((invstedAmnt * getTotalChargeBack(totalPrice)) / (totalPrice));
		System.out.println("for Individual amount Invested is "+invstedAmnt+"charge back for amount "+result);
		return result;
	}

	public float convertTonativeCurrency(float priceUSD, int userId){
		float nativeCur = 0;
		return nativeCur;
	}

	public ArrayList<FundUserTransactionDTO> chargeBackforEachUserInFund(String fundId, int stockId,
			int noOfStocks, float totalPrice, ArrayList<UsersOfFundDTO> fundUsersList) 
			throws ClassNotFoundException, IOException, SQLException{

		ArrayList<FundUserTransactionDTO> fundTransactionListDto = new ArrayList<FundUserTransactionDTO>();

		fundTransactionListDto = setIndlTransDTO( stockId, noOfStocks, totalPrice, fundUsersList);
		return fundTransactionListDto;
	}

	public ArrayList<FundUserTransactionDTO> setIndlTransDTO( int stockId, int noOfStocks, float totalPrice,
			ArrayList<UsersOfFundDTO> fundUsersList) throws ClassNotFoundException, IOException, SQLException{

		float totalInvestement = 0;
		float individualInvestmt = 0;
		Scanner input = new Scanner(System.in);
		StockDetailsDAO stock = new StockDetailsDAO();
		ArrayList<FundUserTransactionDTO> fundTransactionDTOsList = new ArrayList<FundUserTransactionDTO>();
		System.out.println("Warning: Sum of each User's Investment should be exactly equal to Toatal price of the Stock Bought");


		for (UsersOfFundDTO user : fundUsersList) {
			user.getUserIdByInt();
			FundUserTransactionDTO eachUserDto = new FundUserTransactionDTO();

			eachUserDto.setStockId(stockId);
			eachUserDto.setUsedId(user.getUserIdByInt());
			eachUserDto.setSotckPricePerUnit(stock.getStockPriceById(stockId));

			System.out.println("Enter the amount Invested by user: "+user.getUserIdByInt());
			individualInvestmt = input.nextFloat();

			if(user.getBalanceAmountLeft() < individualInvestmt){
				System.out.println("Entered Amount is more than Current Bal");
			}

			totalInvestement += individualInvestmt;
			if(totalInvestement <= totalPrice){
				eachUserDto.setAmountInvested(individualInvestmt);
				eachUserDto.setChargeBackInUSD(getIndividualChargeBackInUSD(individualInvestmt, totalPrice));
				eachUserDto.setRole("FUND");
				eachUserDto.setDescription("Buy");
				eachUserDto.setAvailableBalInUSD((float)user.getBalanceAmountLeft() - (eachUserDto.getChargeBackInUSD() +
						individualInvestmt));
				System.out.println("For User "+ eachUserDto.getUsedId());
				System.out.println(eachUserDto.getAmountInvested() +"    "+ eachUserDto.getChargeBackInUSD() +"   "+ eachUserDto.getStockId()+
						"   "+eachUserDto.getAvailableBalInUSD());
				fundTransactionDTOsList.add(eachUserDto);
			}
		}

		return fundTransactionDTOsList;
	}
}
